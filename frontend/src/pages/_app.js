import { GoogleOAuthProvider } from '@react-oauth/google';
import { useEffect, useState } from 'react';
import '@/styles/globals.css';
import '@fontsource/montserrat';
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar";
import { useRouter } from 'next/router';
import AppSidebar from "@/components/custom/sidebar";
import Layout from "@/components/custom/layout";

export default function App({ Component, pageProps }) {
  const router = useRouter();
  
  // Verifica si la ruta actual es '/login'
  const isLoginPage = router.pathname === '/login/login';
  const [open, setOpen] = useState(false);
  useEffect(() => {
    const usuario = localStorage.getItem('usuario');
    //if (!usuario && !isLoginPage) {
    //  router.push('/login');
    //}
    if (usuario && isLoginPage) {
      router.push('/casa');
    }
  }, [router, isLoginPage]);

  return (
    <GoogleOAuthProvider clientId="338339807279-3fke3b892u4vr6hq23kn0at1f8tabl3p.apps.googleusercontent.com">
      {isLoginPage ? (
        <Component {...pageProps} />
      ) : (
        <Layout>
          <Component {...pageProps} />
        </Layout>
      )}
    </GoogleOAuthProvider>
  );
}