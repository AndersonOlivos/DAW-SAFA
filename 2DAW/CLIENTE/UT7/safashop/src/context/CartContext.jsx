import React, { createContext, useState, useContext } from 'react'; // Necesitas createContext y useContext

const CartContext = createContext();

export const CartProvider = ({ children }) => {
    const [cart, setCart] = useState([]);

    const addToCart = (product) => {
        setCart((prev) => {
            const existe = prev.find(item => item.asin === product.asin);
            if (existe) {
                return prev.map(item =>
                    item.asin === product.asin
                        ? { ...item, cantidad: item.cantidad + 1 }
                        : item
                );
            }
            return [...prev, { ...product, cantidad: 1 }];
        });
    };

    const updateQuantity = (id, delta) => {
        setCart((prev) => prev.map(item => {
            if (item.asin === id) {
                const nuevaCant = item.cantidad + delta;
                return nuevaCant > 0 ? { ...item, cantidad: nuevaCant } : item;
            }
            return item;
        }));
    };

    const removeFromCart = (id) => {
        setCart((prev) => prev.filter(item => item.asin !== id));
    };

    return (
        <CartContext.Provider value={{ cart, addToCart, updateQuantity, removeFromCart }}>
            {children}
        </CartContext.Provider>
    );
};

export const useCart = () => {
    return useContext(CartContext);
};