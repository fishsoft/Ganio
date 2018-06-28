package com.morse.ganio.http.okhttp

import android.content.Context
import java.io.IOException
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

class TrustManager {

    companion object {
        /**
         * 不设置证书
         *
         * @return
         */
        fun getUnsafeOkHttpClient(): SSLSocketFactory? {
            try {
                // Create a trust manager that does not validate certificate chains
                val trustAllCerts = arrayOf<X509TrustManager>(object : X509TrustManager {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(chain: Array<X509Certificate>,
                                                    authType: String) {
                    }

                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(chain: Array<X509Certificate>,
                                                    authType: String) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate?> {
                        return arrayOfNulls(0)
                    }
                })

                // Install the all-trusting trust manager
                val sslContext = SSLContext.getInstance("TLS")
                sslContext.init(null, trustAllCerts,
                        SecureRandom())
                // Create an ssl socket factory with our all-trusting manager

                return sslContext
                        .socketFactory
            } catch (e: Exception) {
                throw RuntimeException(e)
            }

        }

        /**
         * 设置证书
         *
         * @return
         */
        fun getSafeOkHttpClient(context: Context/*InputStream... certificates*/): SSLSocketFactory? {
            try {
                val certificateFactory = CertificateFactory.getInstance("X.509")
                val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
                keyStore.load(null)
                var index = 0
                //            for (InputStream certificate : certificates) {
                val certificate = context.assets.open("srca.cer")
                val certificateAlias = Integer.toString(index++)
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate))

                try {
                    certificate?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                //            }

                val sslContext = SSLContext.getInstance("TLS")

                val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
                trustManagerFactory.init(keyStore)

                /************************************双向证书验证 */
                //            KeyStore clientKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                //            clientKeyStore.load(DataApplicaiton.getInstance().getAssets().open("zhy_client.jks"), "123456".toCharArray());
                //            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                //            keyManagerFactory.init(clientKeyStore, "123456".toCharArray());
                /************************************双向证书验证 */

                sslContext.init(null, trustManagerFactory.trustManagers, SecureRandom())
                return sslContext.socketFactory
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }
    }

}