package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class CentroDeDistribucion: DescribeSpec({
    val misiones = Provincia(1300000)
    val sanIgnacio = Ciudad(misiones)
    val laPampa = Provincia(353106)
    val santaRosa = Ciudad(laPampa)

    val vendedor1 = VendedorFijo(sanIgnacio)
    val vendedor2 = Viajante(listOf(misiones))

    val centro1 = CentrosDeDistribucion(sanIgnacio)
    centro1.agregarVendedor(vendedor1)
    centro1.agregarVendedor(vendedor2)



    describe("centro de distribucion"){
        it ("es estrella"){
            centro1.vendedorEstrella().shouldBe(vendedor1)

        }
        it ("puede cubrir"){
            centro1.puedeCubrir(santaRosa).shouldBeFalse()
        }
        it ("es genérico"){
            centro1.esGenerico().shouldBe(listOf())
        }
        it ("es robusto"){
            centro1.esRobusto().shouldBeFalse()
        }
    }
})

