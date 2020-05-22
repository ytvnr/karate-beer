package io.ytvnr.karatebeer

import com.intuit.karate.junit5.Karate

class KarateBeerTest {

    @Karate.Test
    fun testFullPath(): Karate? {
        return Karate.run().tags("~@ignore").relativeTo(javaClass)
    }
}
