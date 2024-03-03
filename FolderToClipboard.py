
from PyQt5 import QtCore, QtGui
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler


app = QtGui.QGuiApplication([])

class MyHandler(FileSystemEventHandler):
    def on_any_event(self, event):
        print(event.event_type, event.src_path)

    def on_created(self, event):
        path = event.src_path.strip()
        print(path)
        data = QtCore.QMimeData()
        url = QtCore.QUrl.fromLocalFile(path)
        print(url)
        data.setUrls([url])
        app.clipboard().setMimeData(data)


event_handler = MyHandler()
observer = Observer()
observer.schedule(event_handler, path=input("Enter folder path (note, use double forward slashes //): "), 
                  recursive=False)
observer.start()


while True:
    try:
        pass
    except KeyboardInterrupt:
        observer.stop()


