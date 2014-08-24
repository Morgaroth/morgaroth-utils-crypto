package pl.morgaroth.utils.crypto

import org.cryptonode.jncryptor.{AES256JNCryptor, CryptorException, InvalidHMACException}

trait AESEncryptions {

  class ToAESEncyptable(data: Array[Byte]) {
    def encrypt(password: String): Option[Array[Byte]] = {
      val cryptor = new AES256JNCryptor
      try {
        val ciphertext = cryptor.encryptData(data, password.toCharArray)
        Some(ciphertext)
      }
      catch {
        case e: CryptorException =>
          e.printStackTrace()
          None
      }
    }
  }

  implicit def wrapIntoEncryptable(string: String) = new ToAESEncyptable(string.getBytes)

  implicit def wrapIntoEncryptable(byteArray: Array[Byte]) = new ToAESEncyptable(byteArray)
}

trait AESDecryptions {

  class AESDecryptable(encrypted: Array[Byte]) {

    def decrypt(password: String): Option[Array[Byte]] = {
      val cryptor = new AES256JNCryptor
      try {
        //      Logger.info("Cipher text in base64: " + ciphertextAsBase64String + ", length: " + ciphertextAsBase64String.length)
        val decryptedData = cryptor.decryptData(encrypted, password.toCharArray)
        Some(decryptedData)
      } catch {
        case e: InvalidHMACException =>
          e.printStackTrace()
          None
        case e: CryptorException =>
          e.printStackTrace()
          None
      }
    }
  }

  implicit def wrapIntoAESDecryptable(encryptedData: Array[Byte]) = new AESDecryptable(encryptedData)
}

trait AESOperations extends AESDecryptions with AESEncryptions
