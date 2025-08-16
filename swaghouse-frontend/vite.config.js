import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'

export default defineConfig({
  plugins: [react(), tailwindcss()],
  server: {
    host: '127.0.0.1', // forces IPv4 instead of ::1 (IPv6)
    port: 3000,         // optional: change if this port causes issues
  }
})
