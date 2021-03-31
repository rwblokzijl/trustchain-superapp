package nl.tudelft.trustchain.currencyii.util.taproot

import nl.tudelft.ipv8.util.toHex
import org.bitcoinj.core.ECKey
import org.junit.Test

import org.junit.Assert.*
import java.math.BigInteger

class MuSigTest {

    @Test
    fun generate_musig_key() {
        val key1 = ECKey.fromPrivate(BigInteger("88218786999700320424912157840922001183470238663577897435520060565802125439712"))
        val key2 = ECKey.fromPrivate(BigInteger("11756621930195768229168784074199362003209438395325908648574429387730312779458"))

        val expected = "023dd5fc3c1766d0a73466a5997da83efcc529107c9ecd0c56e2a28519f0eb3104"
        val actual = MuSig.generate_musig_key(listOf(key1, key2)).second.getEncoded(true).toHex()

        assertEquals(expected, actual)
    }

    @Test
    fun aggregate_schnorr_nonces() {
        val key1 = ECKey.fromPrivate(BigInteger("2c68916c316d82ea8f3ebb27037354741ce080464590268780ffca750c5727f6", 16))
        val key2 = ECKey.fromPrivate(BigInteger("08d538794fcc7766ecc1e0fd9c1642e5cd5147c67807cce4d46144db5fcc8534", 16))

        val expected = "03326be2da46e2af92df7df4affacc9afdd8b0fb80e7958da65da62b6fc67883f4"
        val actual = MuSig.aggregate_schnorr_nonces(listOf(key1, key2)).first.getEncoded(true).toHex()

        assertEquals(expected, actual)
    }
}
