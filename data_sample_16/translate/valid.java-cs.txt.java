public int advance(int target) {upto++;if (upto == docIDs.length) {return docID = NO_MORE_DOCS;}int inc = 10;int nextUpto = upto+10;int low;int high;while (true) {if (nextUpto >= docIDs.length) {low = nextUpto-inc;high = docIDs.length-1;break;}if (target <= docIDs[nextUpto]) {low = nextUpto-inc;high = nextUpto;break;}inc *= 2;nextUpto += inc;}while (true) {if (low > high) {upto = low;break;}int mid = (low + high) >>> 1;int cmp = docIDs[mid] - target;if (cmp < 0) {low = mid + 1;} else if (cmp > 0) {high = mid - 1;} else {upto = mid;break;}}if (upto == docIDs.length) {return docID = NO_MORE_DOCS;} else {return docID = docIDs[upto];}}
public CharVector(int capacity) {if (capacity > 0) {blockSize = capacity;} else {blockSize = DEFAULT_BLOCK_SIZE;}array = new char[blockSize];n = 0;}
public List<Pair<K,V>> getPairs() {List<Pair<K,V>> pairs = new ArrayList<Pair<K,V>>();for (K key : keySet()) {for (V value : get(key)) {pairs.add(new Pair<K,V>(key, value));}}return pairs;}
public TermVectorsReader clone() {return new CompressingTermVectorsReader(this);}
public ResetNetworkInterfaceAttributeResult resetNetworkInterfaceAttribute(ResetNetworkInterfaceAttributeRequest request) {request = beforeClientExecution(request);return executeResetNetworkInterfaceAttribute(request);}
public LogCommand log() {return new LogCommand(repo);}
public String getRawUserInfo() {return userInfo;}
public SoraniStemFilter create(TokenStream input) {return new SoraniStemFilter(input);}
public ByteBuffer put(byte b) {throw new ReadOnlyBufferException();}
public CacheSubnetGroup createCacheSubnetGroup(CreateCacheSubnetGroupRequest request) {request = beforeClientExecution(request);return executeCreateCacheSubnetGroup(request);}
public BlankCellRectangleGroup(int firstRowIndex, int firstColumnIndex, int lastColumnIndex) {_firstRowIndex = firstRowIndex;_firstColumnIndex = firstColumnIndex;_lastColumnIndex = lastColumnIndex;_lastRowIndex = firstRowIndex;}
public static char[] copyOf(char[] original, int newLength) {if (newLength < 0) {throw new NegativeArraySizeException();}return copyOfRange(original, 0, newLength);}
public String resource() {return this.resource;}
public Entry<String, Ref> peek() {if (packedIdx < packed.size() && looseIdx < loose.size()) {Ref p = packed.get(packedIdx);Ref l = loose.get(looseIdx);int cmp = RefComparator.compareTo(p, l);if (cmp < 0) {packedIdx++;return toEntry(p);}if (cmp == 0)packedIdx++;looseIdx++;return toEntry(resolveLoose(l));}if (looseIdx < loose.size())return toEntry(resolveLoose(loose.get(looseIdx++)));if (packedIdx < packed.size())return toEntry(packed.get(packedIdx++));return null;}
public ValueEval getRef3DEval(Ref3DPxg rptg) {SheetRangeEvaluator sre = createExternSheetRefEvaluator(rptg.getSheetName(), rptg.getLastSheetName(), rptg.getExternalWorkbookNumber());return new LazyRefEval(rptg.getRow(), rptg.getColumn(), sre);}
public void serialize(LittleEndianOutput out) {out.writeShort(_extBookIndex);out.writeShort(_firstSheetIndex);out.writeShort(_lastSheetIndex);}
