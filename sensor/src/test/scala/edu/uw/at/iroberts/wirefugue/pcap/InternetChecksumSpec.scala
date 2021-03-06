package edu.uw.at.iroberts.wirefugue.pcap

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by scala on 5/18/17.
  */
class InternetChecksumSpec extends FlatSpec with Matchers {
  import InternetChecksum._
  import akka.util.ByteString

  "onesSum()" should "work according to example in RFC 1071" in {

    val data: IndexedSeq[Byte] = ByteString.fromInts(
      0x00, 0x01, 0xf2, 0x03,
      0xf4, 0xf5, 0xf6, 0xf7
    )

    onesSum(data) shouldEqual 0xddf2.toShort
  }

  "checksumValid" should "return true" in {

    val data: IndexedSeq[Byte] = ByteString.fromInts(
      0x00, 0x01, 0xf2, 0x03,
      0xf4, 0xf5, 0xf6, 0xf7,
      0x22, 0x0d
    )

    checksumValid(data) shouldBe true

  }
}
