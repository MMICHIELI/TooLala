
DELETE FROM ms_order;

INSERT INTO ms_order ("order_id", "delivery_location", "description")
VALUES (nextval('msorderseq'), 'la défense', 'laptop');

INSERT INTO ms_order ("order_id", "delivery_location", "description")
VALUES (nextval('msorderseq'), 'les ulis', 'jeux-vidéo');

INSERT INTO ms_order ("order_id", "delivery_location", "description")
VALUES (nextval('msorderseq'), 'massy', 'stylo ');

INSERT INTO ms_order ("order_id", "delivery_location", "description")
VALUES (nextval('msorderseq'), 'paris', 'poubelle');