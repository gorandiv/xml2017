INSERT INTO firma (id, pib, ime, adresa, broj_racuna, banka_id, ip)
VALUES (1, '11111111111','A', 'Novi Sad, Brace Ribnikar 52a', '123111111111111122', 1, '127.0.0.1:8100')
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
