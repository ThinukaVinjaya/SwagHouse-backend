import { setLoading } from '../store/features/common';
import { getProductBySlug } from '../api/fetchProducts'
import store from '../store/store'


export const loadProductById = async ({ params }) => {
  try {
    store.dispatch(setLoading(true));
    const product = await getProductBySlug(params?.slug); // now matches slug
    store.dispatch(setLoading(false));
    return { product };
  } catch (error) {
    store.dispatch(setLoading(false));
    return { product: null };
  }
};