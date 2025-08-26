import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Shop from './Shop.jsx'
import 'react-multi-carousel/lib/styles.css';
import { RouterProvider } from 'react-router-dom';
import { router } from './routes.jsx';
import Navigation from './components/Navigation/Navigation.jsx';
import { Provider } from 'react-redux';
import store from './store/store.jsx'
import ShopApplicationWrapper from './pages/ShopApplicationWrapper.jsx';


createRoot(document.getElementById('root')).render(
    <Provider store={store}>
    <RouterProvider router={router}>
      
        <ShopApplicationWrapper />
      
    </RouterProvider>
    </Provider>
)
