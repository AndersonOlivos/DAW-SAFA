<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    
                    *{
                    margin: 0;
                    padding: 0;
                    box-sizing: border-box;
                    }
                    
                    body{
                    font-family: Arial, Helvetica, sans-serif;
                    width: 100%;
                    }
                    
                    #result_output{
                    width: 100%;
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    gap: 1rem;
                    }
                    
                    .piratas{
                    margin-top: 1rem;
                    background-color: #f84545;
                    color: white;
                    font-size: x-large;
                    font-weight: bold;
                    text-align: center;
                    border-radius: 10px;
                    padding: 10px;
                    }
                    
                    .pirata{
                    background-color: #e9e9e9a6;
                    max-width: 700px;
                    width: 100%;
                    display: grid;
                    grid-template-columns: 1fr 1fr;
                    gap: 10px;
                    padding: 10px;
                    border-radius: 10px;
                    overflow: hidden;
                    }
                    
                    .pirata>div{
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: space-between;
                    padding: 0.5rem;
                    gap: 0.5rem;
                    }
                    
                    .pirata-nombre{
                    width: 100%;
                    display: flex;
                    flex-direction: row;
                    align-items: center;
                    justify-content: flex-start;
                    gap: 0.5rem;
                    font-size: large;
                    font-weight: 800;
                    color: #4472e6;
                    text-transform: uppercase;
                    }
                    
                    .pirata-img{
                    width: 100%;
                    }
                    
                    .pirata-div-data{
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    gap: 1rem;
                    width: 100%;
                    margin-bottom: 10px;
                    }
                    
                    .pirata-datos-titulo{
                    padding: 7px;
                    width: 100%;
                    background-color: #4472e6;
                    color: white;
                    font-weight: normal;
                    border-radius: 10px;
                    text-align: center;
                    }
                    
                    table{
                    width: 100%;
                    border-spacing: 0;
                    }
                    
                    td{
                    padding: 8px;
                    margin: 0;
                    border: 1px solid #aeaeae;
                    }

                    th{
                    padding: 8px;
                    margin: 0;
                    border: 1px solid #aeaeae;
                    text-transform: uppercase;
                    background-color: #e1e796;
                    }
                    
                    .pirata-datos-generales{
                    display: flex;
                    flex-direction: column;
                    align-self: center;
                    justify-self: center;
                    gap: .5rem;
                    margin-bottom: 10px;
                    font-weight: bold;
                    }
                    
                    .pirata-datos-generales>p>span{
                    font-weight: 100;
                    }
                    
                    .pirata-numero-evoluciones{
                    border: 1px solid #aeaeae;
                    padding: 10px 20px 10px 20px;
                    }

                    .nombre-completo-pirata{
                        margin-right: 5px;
                    }
                    
                </style>
                
            </head>
            <body>
                <div class="piratas">Piratas</div>
                <xsl:for-each select="piratas/pirata">

                    <div class="pirata">

                        <!-- PRIMERA COLUMNA -->

                        <div class="">
                            <div class="pirata-div-data">
                                <h3 class="pirata-datos-titulo">Actor</h3>
                                <div class="pirata-datos-generales">
                                    <p>Nombre completo: <span class="nombre-completo-pirata"><xsl:value-of select="datos_actor/nombre" /></span> <span><xsl:value-of select="datos_actor/apellidos" /></span></p>
                                    <p>Sexo: <span><xsl:value-of select="datos_actor/sexo" /></span></p>
                                    <p>Fecha nacimiento: <span><xsl:value-of select="datos_actor/nacimiento" /></span></p>
                                </div>
                            </div>
                            <div class="pirata-div-data">
                                <h3 class="pirata-datos-titulo">Roles</h3>
                                <table>
                                    <tr>
                                        <th>TÍTULO</th>
                                        <th>SAGA</th>
                                    </tr>
                                    <xsl:for-each select="peliculas/pelicula/datos">
                                        <tr>
                                        <td><xsl:value-of select="titulo" /></td>
                                        <td><xsl:value-of select="saga" /></td>
                                    </tr>
                                    </xsl:for-each>
                                </table>
                            </div>
                        </div>

                        <!-- SEGUNDA COLUMNA -->

                        <div class="">
                            <h3 class="pirata-datos-titulo"><xsl:value-of select="@nombre" /></h3>
                            <img class="pirata-img" alt="Imagen del pirata">
                                <xsl:attribute name="src">
                                    <xsl:value-of select="@imagen" />
                                </xsl:attribute>
                            </img>
                            
                            <div class="pirata-div-data">
                                <h3 class="pirata-datos-titulo">Roles</h3>
                                <table>
                                    <tr>
                                        <th>TIPO</th>
                                        <th>BARCO</th>
                                    </tr>
                                    <xsl:for-each select="roles/rol">
                                        <tr>
                                        <td><xsl:value-of select="tipo_rol" /></td>
                                        <td><xsl:value-of select="barco" /></td>
                                    </tr>
                                    </xsl:for-each>
                                </table>
                            </div>
                        </div>
                    </div>
                </xsl:for-each>
                </body>
            </html>    
        </xsl:template>
    </xsl:stylesheet>