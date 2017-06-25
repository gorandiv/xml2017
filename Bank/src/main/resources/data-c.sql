INSERT INTO banka (id, ime, adresa, cb_adr , swift_kod)
VALUES (1, 'C', '127.0.0.1:8090', '127.0.0.1:8080','bankaC')
ON DUPLICATE KEY UPDATE id=id;