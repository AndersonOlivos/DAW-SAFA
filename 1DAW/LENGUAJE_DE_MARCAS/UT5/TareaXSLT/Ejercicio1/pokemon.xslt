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
                    
                    .pokedex{
                    margin-top: 1rem;
                    background-color: #f84545;
                    color: white;
                    font-size: x-large;
                    font-weight: bold;
                    text-align: center;
                    border-radius: 10px;
                    padding: 10px;
                    }
                    
                    .pokemon{
                    background-color: #e9e9e9a6;
                    max-width: 700px;
                    width: 100%;
                    display: grid;
                    grid-template-columns: 1fr 1fr 1fr;
                    gap: 10px;
                    padding: 10px;
                    border-radius: 10px;
                    }
                    
                    .pokemon>div{
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: flex-start;
                    padding: 0.5rem;
                    gap: 0.5rem;
                    }
                    
                    .pokemon-nombre{
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
                    
                    .pokemon-img{
                    width: 100%;
                    }
                    
                    .pokemon-div-data{
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    gap: 1rem;
                    width: 100%;
                    margin-bottom: 10px;
                    }
                    
                    .pokemon-datos-titulo{
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
                    text-transform: uppercase;
                    }
                    
                    .pokemon-datos-generales{
                    display: flex;
                    flex-direction: column;
                    align-self: flex-start;
                    justify-self: flex-start;
                    gap: .5rem;
                    margin-bottom: 10px;
                    font-weight: bold;
                    }
                    
                    .pokemon-datos-generales>p>span{
                    font-weight: 100;
                    }
                    
                    .pokemon-numero-evoluciones{
                    border: 1px solid #aeaeae;
                    padding: 10px 20px 10px 20px;
                    }
                    
                </style>
                
            </head>
            <body>
                <div class="pokedex">Pokedex</div>
                <xsl:for-each select="pokedex/pokemon">

                    <div class="pokemon">

                        <!-- PRIMERA COLUMNA -->

                        <div class="">
                            <h1 class="pokemon-nombre"><span><xsl:value-of select="@num_pokedex" /></span><xsl:value-of select="@nombre" /></h1>
                            <img class="pokemon-img" alt="Imagen del pokemon Bulbasaur">
                                <xsl:attribute name="src">
                                    <xsl:value-of select="@url_imagen" />
                                </xsl:attribute>
                            </img>
                            <div class="pokemon-div-data">
                                <h3 class="pokemon-datos-titulo">Habilidades</h3>
                                <table>
                                    <xsl:for-each select="tipologia/debilidades/debilidad">
                                        <tr>
                                        <td><xsl:value-of select="tipo_debilidad" /></td>
                                        <td><xsl:value-of select="efectividad" /></td>
                                    </tr>
                                    </xsl:for-each>
                                </table>
                            </div>
                        </div>

                        <!-- SEGUNDA COLUMNA -->

                        <div class="">
                            <div class="pokemon-div-data">
                                <h3 class="pokemon-datos-titulo">Datos generales</h3>
                                <div class="pokemon-datos-generales">
                                    <p>Altura: <span><xsl:value-of select="datos_generales/altura" /> m</span></p>
                                    <p>Peso: <span><xsl:value-of select="datos_generales/peso" /> kg</span></p>
                                    <p>Sexo: <span><xsl:value-of select="datos_generales/sexo" /></span></p>
                                    <p>Categoria: <span><xsl:value-of select="datos_generales/categoria" /></span></p>
                                    <p>Habilidad: <span><xsl:value-of select="datos_generales/habilidad" /></span></p>
                                </div>
                            </div>
                            <div class="pokemon-div-data">
                                <h3 class="pokemon-datos-titulo">Fortalezas</h3>
                                <table>
                                    <xsl:for-each select="tipologia/fortalezas/fortaleza">
                                        <tr>
                                        <td><xsl:value-of select="tipo_fortaleza" /></td>
                                        <td><xsl:value-of select="efectividad_fortaleza" /></td>
                                    </tr>
                                    </xsl:for-each>
                                </table>
                            </div>
                        </div>

                        <!-- TERCERA COLUMNA -->

                        <div class="">
                            <div class="pokemon-div-data">
                                <h3 class="pokemon-datos-titulo">Stats Base</h3>
                                <table>
                                    <tr>
                                        <td>PS</td>
                                        <td><xsl:value-of select="stats_base/ps" /></td>
                                    </tr>
                                    <tr>
                                        <td>AT</td>
                                        <td><xsl:value-of select="stats_base/at" /></td>
                                    </tr>
                                    <tr>
                                        <td>DEF</td>
                                        <td><xsl:value-of select="stats_base/def" /></td>
                                    </tr>
                                    <tr>
                                        <td>SPAT</td>
                                        <td><xsl:value-of select="stats_base/spat" /></td>
                                    </tr>
                                    <tr>
                                        <td>SDEF</td>
                                        <td><xsl:value-of select="stats_base/def" /></td>
                                    </tr>
                                    <tr>
                                        <td>VEL</td>
                                        <td><xsl:value-of select="stats_base/vel" /></td>
                                    </tr>
                                </table>
                            </div>
                            <div class="pokemon-div-data">
                                <h3 class="pokemon-datos-titulo">Nº Evoluciones</h3>
                                <div class="pokemon-numero-evoluciones"><xsl:value-of select="count(evoluciones/evolucion)" /></div>
                            </div>
                        </div>
                        
                    </div>
                </xsl:for-each>
                </body>
            </html>    
        </xsl:template>
    </xsl:stylesheet>