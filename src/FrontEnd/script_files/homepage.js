$(document).ready(function() {
    // Toggle detailed sections on button click
    $('.details-btn').on('click', function() {
        const sectionId = $(this).data('section');
        $('#' + sectionId).slideToggle(300); // Smooth toggle of the selected section
    });

    // Simulated login status (true if logged in, false if not)
    const isLoggedIn = false; // Change to 'true' to simulate a logged-in user

    // Load navigation menu based on login status
    function loadNavMenu() {
        const navMenu = $('#nav-menu');

        if (isLoggedIn) {
            // Populate menu for logged-in users
            navMenu.html(`
                <li><a href="#">Expense</a>
                    <ul>
                        <li><a href="#">Add</a></li>
                        <li><a href="#">View</a></li>
                    </ul>
                </li>
                <li><a href="#">Investment</a>
                    <ul>
                        <li><a href="#">Add</a></li>
                        <li><a href="#">View</a></li>
                    </ul>
                </li>
                <li><a href="#">Equity</a>
                    <ul>
                        <li><a href="#">Add</a></li>
                        <li><a href="#">View</a></li>
                    </ul>
                </li>
                <li><a href="#">Profile</a>
                    <ul>
                        <li><a href="#">View</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </li>
            `);
        } else {
            // Populate menu for guests
            navMenu.html(`
                <li><a href="#">Register</a></li>
                <li><a href="#">Login</a></li>
            `);
        }
    }

    // Initialize navigation menu on page load
    loadNavMenu();

    // Day/Night Mode Toggle
    const themeToggleBtn = $('#theme-toggle-btn');
    const body = $('body');

    themeToggleBtn.on('click', function() {
        // Toggle the body class for theme
        body.toggleClass('night-mode day-mode');

        // Update the button text based on the current mode
        const isNightMode = body.hasClass('night-mode');
        themeToggleBtn.text(isNightMode ? '🌙 Night Mode' : '🌞 Day Mode');
    });

    // Set default theme
    body.addClass('day-mode');
});
