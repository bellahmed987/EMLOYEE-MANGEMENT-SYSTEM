
import Header from './header';
import Footer from './footer';
import { Outlet, useNavigation } from 'react-router-dom';
export default function applayout(){
 const navigate=useNavigation();
 if(navigate.state=="loading")return(
    <>
     <Header/>
    <h1>loading....</h1>
    <Footer/>
   </>
 )
 else
 return(<>
 <Header/>
 <Outlet/>
 <Footer/>
 </>)
}