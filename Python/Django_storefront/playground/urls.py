from django.urls import path
from . import views

# URLConfiguration
urlpatterns = [
    path('hi/', views.say_hi),
]