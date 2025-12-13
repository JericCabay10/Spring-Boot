//Cash in overlay
document.addEventListener("DOMContentLoaded", function() {
   const openBtn = document.getElementById('openCshInBtn');
       const overlay = document.getElementById('cshInOverlay');
       const closeBtn = document.getElementById('cshInClose');

       openBtn.addEventListener('click', () => {
           overlay.style.display = 'flex';
       });

       closeBtn.addEventListener('click', () => {
           overlay.style.display = 'none';
       });

       overlay.addEventListener('click', (e) => {
           if(e.target === overlay) {
               overlay.style.display = 'none';
           }
       });
});

//Transfer money overlay
document.addEventListener("DOMContentLoaded", function() {
   const openBtn = document.getElementById('openTransfer');
       const overlay = document.getElementById('transferOverlay');
       const closeBtn = document.getElementById('close');

       openBtn.addEventListener('click', () => {
           overlay.style.display = 'flex';
       });

       closeBtn.addEventListener('click', () => {
           overlay.style.display = 'none';
       });

       overlay.addEventListener('click', (e) => {
           if(e.target === overlay) {
               overlay.style.display = 'none';
           }
       });
});


//Transaction history money overlay
document.addEventListener("DOMContentLoaded", function() {
   const openBtn = document.getElementById('openTransaction');
   const overlay = document.getElementById('transactionHistoryOverlay');
   const closeBtn = document.getElementById('closeHistory');

       openBtn.addEventListener('click', () => {
           overlay.style.display = 'flex';
       });

       closeBtn.addEventListener('click', () => {
           overlay.style.display = 'none';
       });

       overlay.addEventListener('click', (e) => {
           if(e.target === overlay) {
               overlay.style.display = 'none';
           }
       });
});