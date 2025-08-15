import { createBrowserRouter } from "react-router-dom";
import Shop from "./Shop.jsx"; // or just "./Shop" after renaming
import ProductListPage from "./pages/ProductListPage/ProductListPage.jsx";
import ShopApplicationWrapper from "./pages/ShopApplicationWrapper.jsx";

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
      }
    ]
  }
]);
