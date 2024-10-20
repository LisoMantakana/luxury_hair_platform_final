import { useNavigate } from "react-router-dom";

const CheckoutComplete = () => {
    const navigate = useNavigate();

    const handleContinueShopping = () => {
        navigate('/products');
    };

    const handleLogout = () => {
        console.log('User logged out');
        navigate('/login');
    };

    return (
        <div className="complete-checkout">
            <div style={styles.overlay}>
                <h1 style={styles.title}>Thank You for Shopping with Luxury Hair!</h1>
                <div style={styles.buttonContainer}>
                    <button style={styles.button} onClick={handleContinueShopping}>
                        Continue Shopping
                    </button>
                    <button style={styles.button} onClick={handleLogout}>
                        Log Out
                    </button>
                </div>
            </div>
        </div>
    );
};

const styles = {
    overlay: {
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
        padding: '20px',
        borderRadius: '10px',
        textAlign: 'center',
        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.2)',
        color: '#fff',
    },
    title: {
        fontSize: '24px',
        marginBottom: '20px',
    },
    buttonContainer: {
        display: 'flex',
        gap: '20px',
        justifyContent: 'center',
    },
    button: {
        padding: '10px 20px',
        fontSize: '16px',
        cursor: 'pointer',
        border: 'none',
        borderRadius: '5px',
        backgroundColor: '#4CAF50',
        color: 'white',
        transition: 'background-color 0.3s',
        boxShadow: '0 2px 4px rgba(0, 0, 0, 0.2)',
    },
};

export default CheckoutComplete;
