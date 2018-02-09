/*
 * 
 * Which is true about following code fragment? 
 * (Choose two options)
 * 
 * Path dir = Paths.get (filename);
 * WathcService watch = dir.geFileSystem().newWatchService();
 * dir.register (watch, ENTRY_MODIFY, ENTRY_DELETE);
 * 
 * Please select:
 * 
 * A. We should use try/catch or declare to be thrown IOException only the "newWatchService()" throws IOException.
 * 
 * B. We should use try/catch or declare to be thrown IOException since the "newWatchService()" and register
 *  throws IOException.
 *  
 * C.  We should use try/catch or declare to be thrown IOException since "register()" throws an InterruptedException
 * 
 * D. Using this code fragment, we can register the directory in filename to be signaled when the deletion or modification occurs 
 * on the directory's elements.
 * 
 * E. Using this code fragment, we can register filename directory to be signaled when the creation, 
 * deletion or modification occurs on the dircetory's element
 */

