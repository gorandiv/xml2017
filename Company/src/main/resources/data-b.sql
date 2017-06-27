INSERT INTO firma (id, pib, ime, adresa, banka_id, adresa)
VALUES (2, '22222222222','B', 'Sremska Kamenica, Lole Ribara 14', 2, '127.0.0.1:8101')
ON DUPLICATE KEY UPDATE id=id;

INSERT INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id, jel_proizvod)
VALUES ('Proizvod1', 'cm^2', 2000.0, 12, 2, true) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id, jel_proizvod)
VALUES ('Proizvod2', 'kg', 100.0, 10.0, 2, true) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id, jel_proizvod)
VALUES ('Usluga2', 'km', 115.0, 17, 2, false) ON DUPLICATE KEY UPDATE id=id;

INSERT INTO racun_fime(firma_id, broj_racuna, stanje_racuna) VALUES (2, 321222333225522233, 299000.0) ON DUPLICATE KEY UPDATE id=id;
INSERT INTO racun_fime(firma_id, broj_racuna, stanje_racuna) VALUES (2, 321222333225522233, 50000.0) ON DUPLICATE KEY UPDATE id=id;
