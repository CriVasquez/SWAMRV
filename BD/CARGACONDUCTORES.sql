--------------------------------------------------------
--  File created - jueves-mayo-03-2012   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure CARGACONDUCTORES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SOPRAFAMRV"."CARGACONDUCTORES" (
v_rut IN conductor.rut_conductor%type,
v_nombre OUT conductor.nombre%type,
v_apepa OUT  conductor.apellido_paterno%type,
v_apema OUT  conductor.apellido_materno%type,
v_dire OUT conductor.direccion%type,
v_fono OUT conductor.telefono%type,
v_email OUT conductor.email%type,
v_comuna OUT conductor.id_comuna%type,
v_fechain OUT conductor.fecha_ingreso%type,
v_fechare OUT conductor.fecha_retiro%type,
v_fechana OUT conductor.fecha_nacimiento%type,
v_radio OUT conductor.radio%type,
v_licencia OUT conductor.licencia%type,
v_detalle OUT conductor.detalle%type,
v_foto OUT conductor.foto%type)

as
/*e_personalRegistrado exception;
v_cuenta NUMBER :=0;*/
BEGIN
/*SELECT COUNT(*)
INTO v_cuenta
FROM CONDUCTOR
WHERE RUT_CONDUCTOR IN (v_rut);
--ARREGLADO el IF
IF (v_cuenta = 0) then
raise e_personalRegistrado;
else*/
SELECT nombre, apellido_paterno, apellido_materno, direccion, telefono, email, id_comuna, fecha_ingreso, fecha_retiro, fecha_nacimiento, radio, licencia, detalle, foto
INTO v_nombre, v_apepa, v_apema, v_dire, v_fono, v_email, v_comuna, v_fechain, v_fechare, v_fechana, v_radio, v_licencia, v_detalle, v_foto
FROM CONDUCTOR WHERE RUT_CONDUCTOR = v_rut;
--end if;
commit;
exception
WHEN NO_DATA_FOUND then
DBMS_OUTPUT.PUT_LINE ('RUT '||v_rut||' no encontrado');

/*WHEN e_personalRegistrado then
RAISE_APPLICATION_ERROR (-20100, 'Conductor '||v_rut||' no esta disponible');*/
WHEN OTHERS THEN
RAISE_APPLICATION_ERROR (-20200, 'Ha ocurrido un error al registrar al Conductor '||v_rut||'. Operacion interrumpida.');
rollback;
end;

/
