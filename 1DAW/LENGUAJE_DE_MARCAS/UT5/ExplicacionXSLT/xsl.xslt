<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <table border="1">
                    <tr bgcolor="#242424">
                        <th>ID Producto</th>
                        <th>Nombre</th>
                        <th>Origen</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                    </tr>
                    <xsl:for-each select="canasta/producto">
                        <tr>
                            <td><xsl:value-of select="@IdProducto"></xsl:value-of></td>
                            <td><xsl:value-of select="nombre"></xsl:value-of></td>
                            <td><xsl:value-of select="origen"></xsl:value-of></td>
                            <td><xsl:value-of select="cantidad"></xsl:value-of></td>
                            <td><xsl:value-of select="precio"></xsl:value-of></td>
                        </tr>
                    </xsl:for-each>
                    
                </table>
            </body>
        </html>    
    </xsl:template>
</xsl:stylesheet>