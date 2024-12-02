from PyQt5.QtWidgets import QMainWindow, QApplication, QTableWidgetItem
from PyQt5.QtCore import QDate
from PyQt5.uic import loadUi
from metodos import *
import re


def es_numero_valido(valor):
    valor = valor.replace(",", ".")
    return bool(re.match(r"^\d+(\.\d+)?$", valor))

def obtener_valor_o_none(valor):
    # Si el valor está vacío o es None, devuelve None; de lo contrario, devuelve el valor original
    return None if valor == "" or valor is None else float(valor)


class VentanaPrincipal(QMainWindow):
    def __init__(self):
        super(VentanaPrincipal, self).__init__()
        loadUi('./DISEÑO/crud_design.ui', self)
        self.modificar_id_jugador_actual = None


        # CONECTAR BOTONES CON PAGINAS
        self.nav_boton_jugadores.clicked.connect(self.cargar_datos_tabla)
        self.nav_boton_anadir.clicked.connect(lambda: self.main.setCurrentWidget(self.anadir))
        self.nav_boton_modificar.clicked.connect(lambda: self.main.setCurrentWidget(self.modificar))
        self.nav_boton_eliminar.clicked.connect(lambda: self.main.setCurrentWidget(self.eliminar))


        #CONECTAR BOTON REFRESCAR A LA FUNCION DE CARGAR DATOS TABLA
        self.btn_refrescar_jugadores.clicked.connect(self.cargar_datos_tabla)
        self.btn_buscar_jugadores.clicked.connect(self.cargar_datos_tabla_filtrado)
        self.btn_anadir_anadir.clicked.connect(self.anadir_jugador)
        self.btn_buscar_eliminar.clicked.connect(self.cargar_datos_tabla_eliminar)
        self.btn_eliminar.clicked.connect(self.eliminar_jugador)
        self.btn_buscar_modificar.clicked.connect(self.cargar_datos_modificar)
        self.btn_modificar.clicked.connect(self.modificar_jugador)



    # CARGAR DATOS
    def cargar_datos_tabla(self):
        self.inp_buscador_jugadores.setText('')
        self.main.setCurrentWidget(self.jugadores)
        jugadores = consultar_datos()
        self.tabla_jugadores.setRowCount(len(jugadores))

        for fila, jugador in enumerate(jugadores, start=0):
            for columna, campo_jugador in enumerate(jugador.values(), start=0):
                self.tabla_jugadores.setItem(fila, columna, QTableWidgetItem(str(campo_jugador)))
        self.tabla_jugadores.resizeColumnsToContents()

    def cargar_datos_tabla_filtrado(self):
        texto_filtro = self.inp_buscador_jugadores.text()
        if texto_filtro != "":
            jugadores_filtrado = consultar_datos_filtrado(texto_filtro)
            self.tabla_jugadores.setRowCount(len(jugadores_filtrado))

            for fila, jugador_filtrado in enumerate(jugadores_filtrado, start=0):
                for columna, campo_jugador_filtrado in enumerate(jugador_filtrado.values(), start=0):
                    self.tabla_jugadores.setItem(fila, columna, QTableWidgetItem(str(campo_jugador_filtrado)))
            self.tabla_jugadores.resizeColumnsToContents()

    def cargar_datos_tabla_eliminar(self):
        texto_filtro = self.inp_buscador_eliminar.text()
        if texto_filtro != "":
            jugadores_filtrado = consultar_datos_filtrado(texto_filtro)

            self.tabla_eliminar.setRowCount(len(jugadores_filtrado))
            for fila, jugador_filtrado in enumerate(jugadores_filtrado, start=0):
                for columna, campo_jugador_filtrado in enumerate(jugador_filtrado.values(), start=0):
                    self.tabla_eliminar.setItem(fila, columna, QTableWidgetItem(str(campo_jugador_filtrado)))
            self.tabla_eliminar.resizeColumnsToContents()

    def anadir_jugador(self):
        anadir_nombre = self.inp_anadir_nombre.text()
        anadir_ranking = self.inp_anadir_ranking.text()
        anadir_puntos = self.inp_anadir_puntos.text()
        anadir_posicion = self.inp_anadir_posicion.text()
        anadir_pareja = self.inp_anadir_pareja.text()
        anadir_pais = self.inp_anadir_pais.text()
        anadir_partidos_jugados = self.inp_anadir_partidos_jugados.text()
        anadir_partidos_ganados = self.inp_anadir_partidos_ganados.text()
        anadir_partidos_perdidos = self.inp_anadir_partidos_perdidos.text()
        anadir_victorias_consecutivas = self.inp_anadir_victorias_consecutivas.text()
        anadir_efectividad = self.inp_anadir_efectividad.text()
        anadir_titulos = self.inp_anadir_titulos.text()
        anadir_fecha_nacimiento = self.inp_anadir_fecha_nacimiento.date().toString("dd/MM/yyyy")
        anadir_pais_nacimiento = self.inp_anadir_pais_nacimiento.text()
        anadir_lugar_residencia = self.inp_anadir_lugar_residencia.text()
        anadir_altura = self.inp_anadir_altura.text()
        anadir_url_fotografia = self.inp_anadir_url_fotografia.text()
        anadir_inp_sexo = 'F' if self.inp_anadir_sexo_f.isChecked() else 'M'

        campos_obligatorios = [anadir_nombre, anadir_ranking, anadir_puntos, anadir_posicion, anadir_pais, anadir_fecha_nacimiento,
                               anadir_pais_nacimiento, anadir_inp_sexo]

        campos_numericos = [anadir_ranking, anadir_puntos, anadir_partidos_jugados, anadir_partidos_ganados, anadir_partidos_perdidos,
                            anadir_victorias_consecutivas, anadir_titulos, anadir_altura]

        if any(campo.strip() == "" for campo in campos_obligatorios):
            self.p_campos_obligatorios.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
            self.p_campos_obligatorios.setText('Error: falta algun campo obligatorio por rellenar')

        else:

            self.p_campos_obligatorios.setText('')

            if any(campo != "" and es_numero_valido(campo) is False for campo in campos_numericos):
                self.p_campos_obligatorios.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
                self.p_campos_obligatorios.setText('Error: formato incorrecto.')
            else:

                anadir_ranking = obtener_valor_o_none(anadir_ranking)
                anadir_puntos = obtener_valor_o_none(anadir_puntos)
                anadir_partidos_jugados = obtener_valor_o_none(anadir_partidos_jugados)
                anadir_partidos_ganados = obtener_valor_o_none(anadir_partidos_ganados)
                anadir_partidos_perdidos = obtener_valor_o_none(anadir_partidos_perdidos)
                anadir_victorias_consecutivas = obtener_valor_o_none(anadir_victorias_consecutivas)
                anadir_titulos = obtener_valor_o_none(anadir_titulos)
                anadir_altura = obtener_valor_o_none(anadir_altura.replace(',','.'))

                jugador = {'Nombre': anadir_nombre,
                           'Sexo': anadir_inp_sexo,
                           'Numero_ranking': anadir_ranking,
                           'Pais': anadir_pais,
                           'Puntos': anadir_puntos,
                           'Posicion': anadir_posicion,
                           'Pareja': anadir_pareja,
                           'Fecha nacimiento': anadir_fecha_nacimiento,
                           'Altura': anadir_altura,
                           'Pais nacimiento': anadir_pais_nacimiento,
                           'Lugar residencia': anadir_lugar_residencia,
                           'Partidos jugados': anadir_partidos_jugados,
                           'Partidos ganados': anadir_partidos_ganados,
                           'Partidos perdidos': anadir_partidos_perdidos,
                           'Victorias consecutivas': anadir_victorias_consecutivas,
                           'Efectividad': anadir_efectividad,
                           'Titulos': anadir_titulos,
                           'Foto jugador': anadir_url_fotografia
                }

                try:
                    insertar_registro_nuevo(jugador)
                    self.p_campos_obligatorios.setStyleSheet("font-size: 20px; font-weight: bold; color: lightgreen;")
                    self.p_campos_obligatorios.setText('Jugador añadido con éxito.')

                    self.inp_anadir_nombre.setText("")
                    self.inp_anadir_ranking.setText("")
                    self.inp_anadir_puntos.setText("")
                    self.inp_anadir_posicion.setText("")
                    self.inp_anadir_pareja.setText("")
                    self.inp_anadir_pais.setText("")
                    self.inp_anadir_partidos_jugados.setText("")
                    self.inp_anadir_partidos_ganados.setText("")
                    self.inp_anadir_partidos_perdidos.setText("")
                    self.inp_anadir_victorias_consecutivas.setText("")
                    self.inp_anadir_efectividad.setText("")
                    self.inp_anadir_titulos.setText("")
                    self.inp_anadir_pais_nacimiento.setText("")
                    self.inp_anadir_lugar_residencia.setText("")
                    self.inp_anadir_altura.setText("")
                    self.inp_anadir_url_fotografia.setText("")

                    return True
                except Exception as e:
                    print(f"Error al insertar el jugador: {e}")
                    return False

    def eliminar_jugador(self):
        # Obtener los elementos seleccionados
        items_seleccionados = self.tabla_eliminar.selectedItems()

        if not items_seleccionados:
            self.p_errores_eliminar.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
            self.p_errores_eliminar.setText('Error: seleccione un jugador.')
            return None

        else:
            self.p_errores_eliminar.setText('')

            # Obtener la fila del primer elemento seleccionado
            fila_seleccionada = items_seleccionados[0].row()

            # Obtener el valor de la primera columna (columna 0) en la fila seleccionada
            jugador_id = self.tabla_eliminar.item(fila_seleccionada, 0).text()

            try:
                eliminar_por_id(jugador_id)
                self.p_errores_eliminar.setStyleSheet("font-size: 20px; font-weight: bold; color: lightgreen;")
                self.p_errores_eliminar.setText('Jugador eliminado con éxito.')
                return True
            except Exception as e:
                print(f"Error al eliminar el jugador: {e}")
                return False

    def cargar_datos_modificar(self):
        texto_filtro = self.inp_buscar_modificar.text()
        if texto_filtro != "" and texto_filtro.isnumeric():

            jugador_modificar = consultar_datos_por_id(texto_filtro)

            if len(jugador_modificar) == 0:
                self.p_error_modificar.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
                self.p_error_modificar.setText('Error: el ID introducido no existe.')
            else:

                self.inp_modificar_nombre.setText(jugador_modificar[0]["nombre"])
                self.inp_modificar_ranking.setText(str(jugador_modificar[0]["numero_ranking"]))
                self.inp_modificar_puntos.setText(str(jugador_modificar[0]["puntos"]))
                self.inp_modificar_posicion.setText(jugador_modificar[0]["posicion"])
                self.inp_modificar_pareja.setText(jugador_modificar[0]["pareja"])
                self.inp_modificar_pais.setText(jugador_modificar[0]["pais"])
                self.inp_modificar_partidos_jugados.setText(str(jugador_modificar[0]["partidos_jugados"]))
                self.inp_modificar_partidos_ganados.setText(str(jugador_modificar[0]["partidos_ganados"]))
                self.inp_modificar_partidos_perdidos.setText(str(jugador_modificar[0]["partidos_perdidos"]))
                self.inp_modificar_victorias_consecutivas.setText(str(jugador_modificar[0]["victorias_consecutivas"]))
                self.inp_modificar_efectividad.setText(jugador_modificar[0]["efectividad"])
                self.inp_modificar_titulos.setText(str(jugador_modificar[0]["titulos"]))

                fecha_nacimiento = QDate.fromString(jugador_modificar[0]["fecha_nacimiento"], "dd/MM/yyyy")
                self.inp_modificar_fecha_nacimiento.setDate(fecha_nacimiento)

                self.inp_modificar_pais_nacimiento.setText(jugador_modificar[0]["pais_nacimiento"])
                self.inp_modificar_altura.setText(str(jugador_modificar[0]["altura"]))
                self.inp_modificar_lugar_residencia.setText(jugador_modificar[0]["lugar_residencia"])
                self.inp_modificar_url_fotografia.setText(jugador_modificar[0]["url_foto"])

                if jugador_modificar[0]["sexo"] == "M":
                    self.inp_modificar_sexo_m.setChecked(True)
                    self.inp_modificar_sexo_f.setChecked(False)
                else:
                    self.inp_modificar_sexo_f.setChecked(True)
                    self.inp_modificar_sexo_m.setChecked(False)

                self.p_error_modificar.setText('')

                self.modificar_id_jugador_actual = jugador_modificar[0]["id"]


        else:
            self.p_error_modificar.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
            self.p_error_modificar.setText('Error: ID inválido.')
            return None

    def modificar_jugador(self):

        if self.modificar_id_jugador_actual is None:
            self.p_error_modificar.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
            self.p_error_modificar.setText("Error: no se ha cargado ningún jugador.")
            return

        modificar_nombre = self.inp_modificar_nombre.text()
        modificar_ranking = self.inp_modificar_ranking.text()
        modificar_puntos = self.inp_modificar_puntos.text()
        modificar_posicion = self.inp_modificar_posicion.text()
        modificar_pareja = self.inp_modificar_pareja.text()
        modificar_pais = self.inp_modificar_pais.text()
        modificar_partidos_jugados = self.inp_modificar_partidos_jugados.text()
        modificar_partidos_ganados = self.inp_modificar_partidos_ganados.text()
        modificar_partidos_perdidos = self.inp_modificar_partidos_perdidos.text()
        modificar_victorias_consecutivas = self.inp_modificar_victorias_consecutivas.text()
        modificar_efectividad = self.inp_modificar_efectividad.text()
        modificar_titulos = self.inp_modificar_titulos.text()
        modificar_fecha_nacimiento = self.inp_modificar_fecha_nacimiento.date().toString("dd/MM/yyyy")
        modificar_pais_nacimiento = self.inp_modificar_pais_nacimiento.text()
        modificar_lugar_residencia = self.inp_modificar_lugar_residencia.text()
        modificar_altura = self.inp_modificar_altura.text()
        modificar_url_fotografia = self.inp_modificar_url_fotografia.text()
        modificar_inp_sexo = 'F' if self.inp_modificar_sexo_f.isChecked() else 'M'

        campos_obligatorios = [modificar_nombre, modificar_ranking, modificar_puntos, modificar_posicion, modificar_pais,
                               modificar_fecha_nacimiento,
                               modificar_pais_nacimiento, modificar_inp_sexo]

        campos_numericos = [modificar_ranking, modificar_puntos, modificar_partidos_jugados, modificar_partidos_ganados,
                            modificar_partidos_perdidos,
                            modificar_victorias_consecutivas, modificar_titulos, modificar_altura]

        if any(campo.strip() == "" for campo in campos_obligatorios):
            self.p_error_modificar.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
            self.p_error_modificar.setText('Error: falta algun campo obligatorio por rellenar')

        else:

            self.p_error_modificar.setText('')

            if any(campo != "" and es_numero_valido(campo) is False for campo in campos_numericos):
                self.p_error_modificar.setStyleSheet("font-size: 15px; font-weight: bold; color: red;")
                self.p_error_modificar.setText('Error: formato incorrecto.')
            else:

                modificar_ranking = obtener_valor_o_none(modificar_ranking)
                modificar_puntos = obtener_valor_o_none(modificar_puntos)
                modificar_partidos_jugados = obtener_valor_o_none(modificar_partidos_jugados)
                modificar_partidos_ganados = obtener_valor_o_none(modificar_partidos_ganados)
                modificar_partidos_perdidos = obtener_valor_o_none(modificar_partidos_perdidos)
                modificar_victorias_consecutivas = obtener_valor_o_none(modificar_victorias_consecutivas)
                modificar_titulos = obtener_valor_o_none(modificar_titulos)
                modificar_altura = obtener_valor_o_none(modificar_altura.replace(',', '.'))

                jugador = {'Nombre': modificar_nombre,
                           'Sexo': modificar_inp_sexo,
                           'Numero_ranking': modificar_ranking,
                           'Pais': modificar_pais,
                           'Puntos': modificar_puntos,
                           'Posicion': modificar_posicion,
                           'Pareja': modificar_pareja,
                           'Fecha nacimiento': modificar_fecha_nacimiento,
                           'Altura': modificar_altura,
                           'Pais nacimiento': modificar_pais_nacimiento,
                           'Lugar residencia': modificar_lugar_residencia,
                           'Partidos jugados': modificar_partidos_jugados,
                           'Partidos ganados': modificar_partidos_ganados,
                           'Partidos perdidos': modificar_partidos_perdidos,
                           'Victorias consecutivas': modificar_victorias_consecutivas,
                           'Efectividad': modificar_efectividad,
                           'Titulos': modificar_titulos,
                           'Foto jugador': modificar_url_fotografia
                           }

                try:
                    modificar_registro(self.modificar_id_jugador_actual,jugador)
                    self.p_error_modificar.setStyleSheet("font-size: 20px; font-weight: bold; color: lightgreen;")
                    self.p_error_modificar.setText('Jugador modificado con éxito.')

                    self.inp_modificar_nombre.setText("")
                    self.inp_modificar_ranking.setText("")
                    self.inp_modificar_puntos.setText("")
                    self.inp_modificar_posicion.setText("")
                    self.inp_modificar_pareja.setText("")
                    self.inp_modificar_pais.setText("")
                    self.inp_modificar_partidos_jugados.setText("")
                    self.inp_modificar_partidos_ganados.setText("")
                    self.inp_modificar_partidos_perdidos.setText("")
                    self.inp_modificar_victorias_consecutivas.setText("")
                    self.inp_modificar_efectividad.setText("")
                    self.inp_modificar_titulos.setText("")
                    self.inp_modificar_pais_nacimiento.setText("")
                    self.inp_modificar_lugar_residencia.setText("")
                    self.inp_modificar_altura.setText("")
                    self.inp_modificar_url_fotografia.setText("")

                    return True
                except Exception as e:
                    print(f"Error al modificar el jugador: {e}")
                    return False

if __name__ == "__main__":
    import sys
    app = QApplication(sys.argv)
    ventana_principal = VentanaPrincipal()
    ventana_principal.show()
    ventana_principal.cargar_datos_tabla()
    sys.exit(app.exec_())