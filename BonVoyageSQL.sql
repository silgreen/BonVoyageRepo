CREATE TABLE recensione (
    idpost bigint,
    titolo VARCHAR(100),
    testo text,
    rating_utente INTEGER,
    idutente bigint
);

CREATE TABLE post (
    strutturaid INTEGER,
    idpost bigint PRIMARY KEY,
    rating_avg DOUBLE DEFAULT 0,
    nrecensioni INTEGER DEFAULT 0,
    info text,
    media VARCHAR(100)
);

CREATE TABLE luogo (
    regione VARCHAR(32),
    citta VARCHAR(32) 
);

CREATE TABLE struttura (
    idstruttura bigint PRIMARY KEY,
    nome VARCHAR(256),
    telefono VARCHAR(10),
    indirizzo VARCHAR(256),
    categoria VARCHAR(32),
    regione VARCHAR(32),
    citta VARCHAR(32),
    tipologia VARCHAR(32),
);

CREATE TABLE tipo_struttura (
    categoria VARCHAR(32),
    tipologia VARCHAR(32)
);

CREATE TABLE utente (
    idutente bigint PRIMARY KEY,
    email VARCHAR(256) UNIQUE,
    username VARCHAR(16) UNIQUE,
    password VARCHAR(256),
    Nrecensioniutente INTEGER DEFAULT 0,
    biografia text,
    data_reg DATE DEFAULT CURRENT_DATE,
    regione VARCHAR(32),
    citta VARCHAR(32),
);



ALTER TABLE struttura ADD CONSTRAINT tipocate_fk FOREIGN KEY(categoria,tipologia) REFERENCES tipo_struttura(categoria,tipologia);
ALTER TABLE struttura ADD CONSTRAINT struttura_luogo_regione_citta_fk FOREIGN KEY(regione,citta) REFERENCES luogo(regione,citta);

ALTER TABLE recensione ADD CONSTRAINT idutente_fk FOREIGN KEY(idutente) REFERENCES utente(idutente) ON DELETE CASCADE;
ALTER TABLE recensione ADD CONSTRAINT idpost_fk FOREIGN KEY(idpost) REFERENCES post(idpost) ON DELETE CASCADE;
ALTER TABLE recensione ADD CONSTRAINT rating_utente CHECK ((rating_utente <= 1) AND (rating_utente <= 5));

ALTER TABLE post ADD CONSTRAINT struttura_fk FOREIGN KEY(strutturaid) REFERENCES struttura(idstruttura) ON DELETE CASCADE;

ALTER TABLE luogo ADD CONSTRAINT luogo_pk PRIMARY key(regione,citta);

ALTER TABLE tipo_struttura ADD CONSTRAINT tipocate_pk PRIMARY key(categoria,tipologia);

ALTER TABLE utente ADD CONSTRAINT utente_luogo_regione_citta_fk FOREIGN KEY(regione,citta) REFERENCES luogo(regione,citta);


create function aggiorna_media() returns trigger
    language plpgsql
as
$$
begin
    update post
    set rating_avg = (select avg(rating_utente) from recensione r where post.idpost = r.idpost)
    where idpost in (select idpost from recensione group by idpost);
    return null;
    end;
$$;


create function aggiorna_n_recensioni_procedure() returns trigger
    language plpgsql
as
$$
BEGIN
    update post
    set nrecensioni = (select count(*) from recensione r where r.idpost = new.idpost)
    where idpost in (select r.idpost from recensione r where r.idpost = new.idpost);
    return null;
    end;
$$;


create function aggiorna_n_recensioni_proceduredel() returns trigger
    language plpgsql
as
$$
BEGIN
    update post
    set nrecensioni = (select count(*) from recensione where idpost = old.idpost)
    where idpost in (select idpost from recensione where idpost = old.idpost);
    return null;
    end;
$$;


create function aggiorna_n_recensioni_utente_procedure() returns trigger
    language plpgsql
as
$$
BEGIN
update utente
    set "Nrecensioniutente" = (select count(*) from recensione where recensione.idutente = utente.idutente);
    return null;
end;
$$;


create function creapost() returns trigger
    language plpgsql
as
$$
begin
        insert into post(strutturaid)
        select idstruttura
        from struttura
        where idstruttura in (select new.idstruttura from struttura);
        return null;
    end;
$$;


create function set_rating_notnull() returns trigger
    language plpgsql
as
$$
begin
        update post
        set rating_avg = 0
        where nrecensioni = 0;
        return null;
    end;
$$;

