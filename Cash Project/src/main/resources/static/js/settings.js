function openTab(tabName) {

    // Hide all content
    document.querySelectorAll('.tab-content').forEach(tab => tab.classList.remove('show'));

    // Show selected tab
    document.getElementById(tabName).classList.add('show');

    // Change active button
    document.querySelectorAll('.tab-btn').forEach(btn => btn.classList.remove('active'));
    event.target.classList.add('active');
}
