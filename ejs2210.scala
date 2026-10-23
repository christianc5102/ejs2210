// Ejercicio 1
class Caja[A]( val contenido: A ){
  def obtener: A = contenido

  def combinar[B](otro: B): (A,B) =
    (contenido ,otro)
}

val cInt = new Caja( 10)
val cStr= new Caja("Scala" )
val cBool = new Caja(true)


// Ejercicio 2
def seleccionarPrimero[A](primero: A,segundo: A): A =
  primero

val pInt = seleccionarPrimero(1 , 2)
val pStr= seleccionarPrimero("a",  "b")
val pDouble = seleccionarPrimero( 1.5,2.5 )


// Ejercicio 3
def transformar[A,B](valor: A ,funcion: A => B): B =
  funcion(valor)

val res1 = transformar(10 ,(x: Int)=> x.toString)
val res2= transformar("hola" , (s: String) => s.length)
val res3 = transformar( 3.14, (d: Double) => d > 0.0 )


// Ejercicio 4
abstract class Vehiculo(val marca: String )
class Automovil(marca: String) extends Vehiculo(marca )
class Motocicleta( marca: String ) extends Vehiculo(marca)

class RegistroVehiculo[A <: Vehiculo](val vehiculo: A)


// Ejercicio 5
abstract class Animal(val nombre: String)
class Perro( nombre: String) extends Animal(nombre )

class Contenedor[+A](val valor: A )

val contenedorPerro: Contenedor[Perro] = new Contenedor(new Perro("Rocky" ))
val contenedorAnimal: Contenedor[Animal] = contenedorPerro


// Ejercicio 6
trait Procesador[-A] {
  def procesar(valor: A): String
}

class ProcesadorAnimal extends Procesador[Animal]{
  def procesar(valor: Animal): String = valor.nombre
}

val procPerro: Procesador[Perro] = new ProcesadorAnimal


// Ejercicio 7
trait Productor[+A] {
  def producir: A
}

trait Consumidor[-A]{
  def consumir(valor: A): String
}

class Gato(nombre: String) extends Animal(nombre)

class ProductorPerro extends Productor[Perro]{
  def producir: Perro = new Perro( "Perro")
}

class ConsumidorAnimal extends Consumidor[Animal] {
  def consumir( valor: Animal ): String = valor.nombre
}

val prodAnimal: Productor[Animal] = new ProductorPerro
val consPerro: Consumidor[Perro]= new ConsumidorAnimal
val consGato: Consumidor[Gato] = new ConsumidorAnimal


// Ejercicio 8
class Resultado[A](
  val valor: A,
  val exitoso: Boolean,
  val mensaje: String
)

val rInt = new Resultado[Int](1,true ,"ok")
val rStr= new Resultado[String]( "dato", true,"ok" )
val rPersona = new Resultado[Persona](new Persona, false, "ok")