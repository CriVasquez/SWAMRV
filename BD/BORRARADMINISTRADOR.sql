--------------------------------------------------------
--  File created - martes-junio-19-2012   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure BORRARADMINISTRADOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SOPRAFAMRV"."BORRARADMINISTRADOR" (
v_rut IN administrador.rut_administrador%type
)

is
BEGIN
DELETE FROM ADMINISTRADOR WHERE rut_administrador = v_rut;

commit;
exception

WHEN NO_DATA_FOUND then
DBMS_OUTPUT.PUT_LINE ('No se han encontrado los datos que desea eliminar');

WHEN OTHERS THEN
RAISE_APPLICATION_ERROR (-20200, 'Ha ocurrido un error al intentar eliminar el administrador' || v_rut || ' . Operacion interrumpida.');
rollback;
end;

/
