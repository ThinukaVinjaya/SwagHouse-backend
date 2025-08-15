import { configureStore } from '@reduxjs/toolkit';
import commonReducer from './commonSlice'; // adjust this based on your actual reducer

const store = configureStore({
  reducer: {
    commonState: commonReducer, // make sure this matches your state structure
  },
});

export default store;