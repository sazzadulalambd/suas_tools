const translations = {
    en: {
        qrcode: "S-QRGen",
        product: "Product",
        pricing: "Pricing",
        enterprise: "Enterprise",
        solution: "Solution",
        help: "Help",
        faq: "FAQ",
        signIn: "Sign In",
        signUp: "Sign Up",
        heroTitle: "Generate and Publish <span class='highlight'>Dynamic</span> QR Codes.",
        heroDesc: "S-QRGen is a dynamic QR code generator. It allows users to easily create customized QR codes for sharing or embedding on their website.",
        getStarted: "Get Started",
        watchDemo: "Watch demo",
        destination: "Destination",
        website: "Website",
        googleDoc: "Google Doc",
        youtube: "YouTube",
        facebook: "Facebook",
        uploadFile: "Upload a File",
        instagram: "Instagram",
        message: "Message",
        email: "Email",
        enterUrl: "Enter your website URL",
        livePreview: "Live Preview",
        company: "Company",
        aboutUs: "About Us",
        careers: "Careers",
        blog: "Blog",
        resources: "Resources",
        documentation: "Documentation",
        tutorials: "Tutorials",
        support: "Support",
        legal: "Legal",
        privacyPolicy: "Privacy Policy",
        termsOfService: "Terms of Service",
        cookiePolicy: "Cookie Policy",
        download:"Download"

    },
    bn: {
        qrcode: "এস-কিউআরজেন",
        product: "প্রোডাক্ট",
        pricing: "মূল্য",
        enterprise: "এন্টারপ্রাইজ",
        solution: "সমাধান",
        help: "সাহায্য",
        faq: "সচরাচর জিজ্ঞাসিত প্রশ্ন",
        signIn: "সাইন ইন",
        signUp: "সাইন আপ",
        heroTitle: "ডাইনামিক <span class='highlight'>কিউআর কোড</span> তৈরি করুন এবং প্রকাশ করুন।",
        heroDesc: "এস-কিউআরজেন একটি ডাইনামিক কিউআর কোড জেনারেটর। এটি ব্যবহারকারীদের সহজে তাদের ওয়েবসাইটে শেয়ার বা এম্বেড করার জন্য কাস্টমাইজড কিউআর কোড তৈরি করতে দেয়।",
        getStarted: "শুরু করুন",
        watchDemo: "ডেমো দেখুন",
        destination: "গন্তব্য",
        website: "ওয়েবসাইট",
        googleDoc: "গুগল ডক",
        youtube: "ইউটিউব",
        facebook: "ফেসবুক",
        uploadFile: "ফাইল আপলোড করুন",
        instagram: "ইনস্টাগ্রাম",
        message: "বার্তা",
        email: "ইমেইল",
        enterUrl: "আপনার ওয়েবসাইট URL লিখুন",
        livePreview: "লাইভ প্রিভিউ",
        company: "কোম্পানি",
        aboutUs: "আমাদের সম্পর্কে",
        careers: "ক্যারিয়ার",
        blog: "ব্লগ",
        resources: "রিসোর্স",
        documentation: "ডকুমেন্টেশন",
        tutorials: "টিউটোরিয়াল",
        support: "সহায়তা",
        legal: "আইনি",
        privacyPolicy: "গোপনীয়তা নীতি",
        termsOfService: "পরিষেবার শর্তাবলী",
        cookiePolicy: "কুকি নীতি",
        download:"ডাউনলোড করুন"
    }
};

document.getElementById('hamburgerBtn').addEventListener('click', function() {
    const navMenu = document.getElementById('navMenu');
    navMenu.classList.toggle('show');
});

document.querySelector('input[type="text"]').addEventListener('input', function() {
    const qrCodeImage = document.getElementById('qrCodeImage');
    qrCodeImage.src = 'https://via.placeholder.com/150';
});

document.getElementById('langToggle').addEventListener('click', function() {
    const currentLang = document.documentElement.lang;
    const newLang = currentLang === 'en' ? 'bn' : 'en';
    document.documentElement.lang = newLang;
    translatePage(newLang);
});

document.getElementById('themeToggle').addEventListener('click', function() {
    const body = document.body;
    const themeToggle = document.getElementById('themeToggle');
    body.classList.toggle('light');
    body.classList.toggle('dark');
    if (body.classList.contains('dark')) {
        themeToggle.textContent = '☀️';
    } else {
        themeToggle.textContent = '🌙';
    }
});

function translatePage(lang) {
    document.querySelectorAll('[data-lang]').forEach(element => {
        const key = element.getAttribute('data-lang');
        element.innerHTML = translations[lang][key];
    });
}

// Initial translation based on default language
translatePage(document.documentElement.lang || 'en');
