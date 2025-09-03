import { createBrowserRouter } from "react-router-dom";
import Shop from "./Shop.jsx"; // or just "./Shop" after renaming
import ProductListPage from "./pages/ProductListPage/ProductListPage.jsx";
import ShopApplicationWrapper from "./pages/ShopApplicationWrapper.jsx";
import ProductDetails from "./pages/ProductDetailPage/ProductDetails.jsx";
import { loadProductById } from "./routes/Product.jsx";
import AuthenticationWrapper from "./pages/AuthenticationWrapper.jsx";
import Login from "./pages/Login/login.jsx";
import Register from "./pages/Register/Register.jsx";
import OAuth2LoginCallback from "./pages/OAuth2LoginCallback.jsx";


export const router = createBrowserRouter([
  {
    path: "/",
    element: <ShopApplicationWrapper/>,
    children:[
      {
        path:'/',
        element:<Shop/>
      },
      {
        path:'/women',
        element:<ProductListPage categoryType={"WOMEN"}/>
      },
      {
        path:'/men',
        element:<ProductListPage categoryType={"MEN"}/>
      },
      {
        path:"/product/:slug",
          loader: loadProductById,
          element: <ProductDetails />
      }
    ]
  },
  {
     path:"/v1/",
      element:<AuthenticationWrapper />,
      children:[
        {
          path:"login",
          element:<Login />
        },
        {
          path:"register",
          element:<Register />
        }
      ]
    },
    {
      path:'/oauth2/callback',
      element:<OAuth2LoginCallback />
    }
]);
