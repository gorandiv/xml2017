INSERT IGNORE INTO firma (id, pib, ime, adresa, broj_racuna, banka_id, ip)
VALUES (2, '22222222222','B', 'Sremska Kamenica, Lole Ribara 14', '321222222222222233', 2, '127.0.0.1:8101');

INSERT IGNORE INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id)
VALUES ('Proizvod1', 'cm^2', 2000.0, 12, 2);
INSERT IGNORE INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id)
VALUES ('Proizvod2', 'kg', 100.0, 10.0, 2);
INSERT IGNORE INTO proizvod_ili_usluga(ime, jedinica_mere, cena, porez, firma_id)
VALUES ('Usluga2', 'km', 115.0, 17, 2);