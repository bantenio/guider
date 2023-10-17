import process from 'node:process'
import path from 'node:path'
import {fileURLToPath, URL} from 'node:url'
import {defineConfig, loadEnv} from 'vite'
import react from '@vitejs/plugin-react'

const envDir = 'env'
const envPrefixes = ['VITE_', 'APP_']

// https://vitejs.dev/config/
export default defineConfig(({mode}) => {
    const env = loadEnv(mode, path.join(process.cwd(), envDir), envPrefixes)
    const srcPath = fileURLToPath(new URL('./src', import.meta.url))
    console.log("frontend src path:", srcPath)
    const confObj = {
        envDir: envDir,
        envPrefix: envPrefixes,
        resolve: {
            alias: {
                '@': srcPath,
                '~': srcPath
            }
        },
        base: './',
        plugins: [
            react()
        ]
    }

    const clientsVal = env.APP_MODULE_HTTP_CLIENTS
    if (clientsVal) {
        const clientFlags = clientsVal.split(',')
        const proxyConfig = {}
        clientFlags.forEach(clientFlag => {
            const upperClientFlag = clientFlag.toUpperCase()
            const proxy = env[`APP_HTTP_${upperClientFlag}_PROXY`]
            if (proxy && proxy.length) {
                const baseUrl = env[`APP_HTTP_${upperClientFlag}_BASE_URL`]
                proxyConfig[baseUrl] = {
                    target: proxy,
                    ws: true,
                    secure: false,
                    changeOrigin: true
                }
            }
        })
        confObj['server'] = {
            proxy: proxyConfig
        }
    }

    return confObj
})
