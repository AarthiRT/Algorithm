<h1>Mirror Image</h1>
<p>You are given a binary tree rooted at 1. You have to find the mirror image of any node qi about node 1. If it doesn't exist then print -1.</p>
<p><b>Input:</b></p>
<p>First line of input is N and Q.</p>
<p>Next N-1 line consists of two integers and one character first of whose is parent node , second is child node and character "L" representing Left child and "R" representing right child.</p>
<p>Next Q lines represents qi.</p>
<p><b>Output:</b></p>
<p>For each qi print it mirror node if it exists else print -1. </p>
<br>
<p><b>NOTE:</b> 1 is mirror image of itself.</p>
<br>
<p><b>Constraints:</b></p>
<p>1 <= N <= 103</p>
<p>1<= Q <= 103</p></p>
<br></p>
<p><b>SAMPLE INPUT</b></p>
<p>10 8</p></p>
<p>1 2 R</p></p>
<p>1 3 L</p></p>
<p>2 4 R</p></p>
<p>2 5 L</p></p>
<p>3 6 R</p></p>
<p>3 7 L</p></p>
<p>5 8 R</p></p>
<p>5 9 L</p></p>
<p>7 10 R</p>
<p>2</p>
<p>5</p>
<p>3</p>
<p>6</p>
<p>1</p>
<p>10</p>
<p>9</p>
<p>4</p>
<br>
<p><b>SAMPLE OUTPUT</b></p>
<p>3</p>
<p>6</p>
<p>2</p>
<p>5</p>
<p>1</p>
<p>-1</p>
<p>-1</p>
<p>7</p>
