select * from  TMOTORKEYVALUE;

INSERT INTO TMOTORKEYVALUE (CLUSTERDB, IDDB, SUCHFILTERDB, DATENDB) VALUES ('SALES', 'ID1', 'VW,Teil1', '<XML>was</XML>');
INSERT INTO TMOTORKEYVALUE (CLUSTERDB, IDDB, SUCHFILTERDB, DATENDB) VALUES ('SALES', 'ID2', 'VW,Teil2', '<XML>wie</XML>');
INSERT INTO TMOTORKEYVALUE (CLUSTERDB, IDDB, SUCHFILTERDB, DATENDB) VALUES ('SALES', 'ID3', 'ADAC,Teil1', '<XML>gelber Engel</XML>');
INSERT INTO TMOTORKEYVALUE (CLUSTERDB, IDDB, SUCHFILTERDB, DATENDB) VALUES ('NN', 'ID4', '', '<XML>nix</XML>');
INSERT INTO TMOTORKEYVALUE (CLUSTERDB, IDDB, SUCHFILTERDB, DATENDB) VALUES ('NN', 'ID5', 'nix', '<XML>gar nix</XML>');

update TMOTORKEYVALUE set suchfilterdb='nix' where iddb='ID4';

SELECT * FROM pg_stat_activity;