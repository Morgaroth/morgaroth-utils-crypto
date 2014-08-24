package pl.morgaroth.utils

import scala.util.Random

trait randoms {
  val randGenerator = Random

  def randomInt = randGenerator.nextInt()

  def randomInt(max: Int) = randGenerator.nextInt(max)
}

object randoms extends randoms {

}
