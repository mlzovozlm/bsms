//login
//register
(getmap - '/login')
String loginPage(Model model){
return "login_page"
}
(postmap - '/login')
String login(User user, String error){
return "home_page"
}

(getmap - '/register')
String registerPage(Model model){
return "register_page"
}
(postmap - '/register')
String register(User user){
return "redirect:/registerSuccess_page"
}
