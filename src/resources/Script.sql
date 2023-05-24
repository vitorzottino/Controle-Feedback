CREATE TABLE tb_feedback (
id_fb varchar2(7) not null primary key,
assunto_fb varchar2(150) not null,
mensagem_fb varchar2(500) not null,
dt_registro date,
dt_saida date,
motivo_fb varchar2(50),
status_fb varchar2(15))

CREATE SEQUENCE SQ_ID_FB START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_insert_id_feedback

BEFORE INSERT ON tb_feedback FOR EACH ROW       
BEGIN
SELECT sq_id_fb.nextval
INTO :NEW.id_FB
FROM DUAL;
END;
/