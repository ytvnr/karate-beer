package io.ytvnr.karatebeer

import com.intuit.karate.Runner
import com.intuit.karate.junit5.Karate
import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test

class KarateBeerTest {

//    @Karate.Test
//    fun testFullPath(): Karate? {
//        return Karate.run().tags("~@ignore").relativeTo(javaClass)
//    }

    @Test
    fun testParallel() {
        val results = Runner.path("classpath:io/ytvnr/karatebeer").tags("~@ignore").parallel(5)
        assertTrue(results.errorMessages, results.failCount == 0)
    }
}
