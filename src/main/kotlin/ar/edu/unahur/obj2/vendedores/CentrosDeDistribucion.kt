package ar.edu.unahur.obj2.vendedores

import java.lang.Exception

class CentrosDeDistribucion(val ciudad: Ciudad) {
    val vendedores = mutableListOf<Vendedor>()

    fun agregarVendedor(vendedor: Vendedor) =
            if(!vendedores.contains(vendedor)){
                vendedores.add(vendedor)
            }
            else{
                throw Exception ("El vendedor ya está registrado para el centro")
            }

    fun vendedorEstrella() = vendedores.maxBy { v -> v.puntajeCertificaciones()}

    fun puedeCubrir(ciudad: Ciudad) = vendedores.any {v -> v.puedeTrabajarEn(ciudad)}

    fun esGenerico() = vendedores.filter { v -> v.esGenerico()}

    fun esRobusto() = vendedores.count {v -> v.esFirme()} >= 3

}

