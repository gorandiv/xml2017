INSERT INTO banka (id, ime, adresa, cb_adr,swift_kod)
VALUES (2, 'D', '127.0.0.1:8091', '127.0.0.1:8080','bankaD')
ON DUPLICATE KEY UPDATE id=id;