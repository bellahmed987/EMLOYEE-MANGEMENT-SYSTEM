export default function Footer() {
    return (
      <footer
        style={{
          position: 'fixed',
          bottom: 0,
          left: 0,
          width: '100%',
          textAlign: 'center',
          padding: '15px',
          fontSize: '1rem',
          backgroundColor: '#4caf50',
          color: '#fff',
          borderTop: '2px solid #4caf50',
        }}
      >
        © {new Date().getFullYear()} All Rights Reserved.
      </footer>
    );
  }
  