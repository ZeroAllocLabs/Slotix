from flask import Flask
app=Flask("test_server")

@app.route('/')
def default():
    return "<h3>welcome to test server. Its used by cache engine to test working</h3>"

app.run(host="0.0.0.0",port=5100)