package tarbi

object predef {

  trait Functor[F[_]] {
    def map[A,B](f: A => B): F[A] => F[B]
  }

  trait Opt[+A]
  case object Non         extends Opt[Nothing]
  case class Val[A](a: A) extends Opt[A]

  implicit class FunctorOps[A, F[A]](functorial: F[A]) given (functor: Functor[F]) {
    def map[B](f: A => B): F[B] =
      functor.map(f)(functorial)
  }

  object Opt {

    def empty[A]: Opt[A] =
      Non
    
    def apply[A](a: A): Opt[A] =
      if (a == null) Non else Val(a)

    implicit def OptFunctor: Functor[Opt] = new Functor[Opt] {
      def map[A, B](f: A => B): Opt[A] => Opt[B] =
        (oa: Opt[A]) => oa match {
          case Non    => Non
          case Val(a) => Val(f(a))
        }
    }
  }

}