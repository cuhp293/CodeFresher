from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
# View function is a request handler function (action)
def say_hi(request):
    # Pull data from database, transform, send email...
    # return HttpResponse('Hi from django')
    return render(request, 'hi.html', {'name': 'sau'})