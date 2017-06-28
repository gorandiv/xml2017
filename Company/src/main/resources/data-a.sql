INSERT INTO firma (id, pib, ime, banka_id, adresa, adresa_firme)
VALUES (1, '11111111111','A', 1, '127.0.0.1:8100', 'Novi Sad, Brace Ribnikar 15')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id, jel_proizvod)
VALUES ('Proizvod1', 'cm^2', 2000.0, 14.1, 1, true)
ON DUPLICATE KEY UPDATE id=id;
INSERT INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id, jel_proizvod)
VALUES ('Usluga1', 'km', 100.0, 10.0, 1, false)
ON DUPLICATE KEY UPDATE id=id;
INSERT INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id, jel_proizvod)
VALUES ('Usluga2', 'km', 115.0, 20.5, 1, false)
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO racun_firme(firma_id, broj_racuna, stanje_racuna) VALUES (1, 123111117711331122, 1000.0) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO racun_firme(firma_id, broj_racuna, stanje_racuna) VALUES (1, 123112115511111122, 50000.0) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO racun_firme(firma_id, broj_racuna, stanje_racuna) VALUES (1, 123111112211151122, 101000.0) ON DUPLICATE KEY UPDATE id=id;
