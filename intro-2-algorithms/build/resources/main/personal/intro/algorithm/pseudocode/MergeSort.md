# 归并排序算法伪代码 #

---

A为一个数组，p, q, r为数组下标，满足p<=q<r.
假设子数组A[p...q] 和 A[q+1...r]均已排好序
```
Merge(A, p, q, r)
  n1 = q - p + 1
  n2 = r - q
  let L[1...n1 + 1] and R[1...n2 + 1] be new arrays
  for i = 1 to n1
      L[i] = A[p + i - 1]
  for j = 1 to n2
      R[j] = A[q + j]
  L[n1 + 1] = Integer.MAX_VALUE
  R[n2 + 1] = Integer.MAX_VALUE
  i = 1
  j = 1
  for k = p to r
      if L[i] <= R[j]
          A[k] = L[i]
          i = i + 1
      else
          A[k] = R[j]
          j = j + 1
```

---