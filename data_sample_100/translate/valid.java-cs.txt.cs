public java.nio.ByteBuffer encode(string s){return encode(java.nio.CharBuffer.wrap(java.lang.CharSequenceProxy.Wrap(s)));}
public virtual IncreaseReplicaCountResponse IncreaseReplicaCount(IncreaseReplicaCountRequest request){var options = new InvokeOptions();options.RequestMarshaller = IncreaseReplicaCountRequestMarshaller.Instance;options.ResponseUnmarshaller = IncreaseReplicaCountResponseUnmarshaller.Instance;return Invoke<IncreaseReplicaCountResponse>(request, options);}
public virtual ListReusableDelegationSetsResponse ListReusableDelegationSets(ListReusableDelegationSetsRequest request){var options = new InvokeOptions();options.RequestMarshaller = ListReusableDelegationSetsRequestMarshaller.Instance;options.ResponseUnmarshaller = ListReusableDelegationSetsResponseUnmarshaller.Instance;return Invoke<ListReusableDelegationSetsResponse>(request, options);}
public CharVector(int capacity){if (capacity > 0){blockSize = capacity;}else{blockSize = DEFAULT_BLOCK_SIZE;}array = new char[blockSize];n = 0;}
public virtual ListConferenceProvidersResponse ListConferenceProviders(ListConferenceProvidersRequest request){var options = new InvokeOptions();options.RequestMarshaller = ListConferenceProvidersRequestMarshaller.Instance;options.ResponseUnmarshaller = ListConferenceProvidersResponseUnmarshaller.Instance;return Invoke<ListConferenceProvidersResponse>(request, options);}
public override string ToString(string field){StringBuilder buffer = new StringBuilder();buffer.Append("spanOr([");bool first = true;foreach (SpanQuery clause in clauses){if (!first) buffer.Append(", ");buffer.Append(clause.ToString(field));first = false;}buffer.Append("])");buffer.Append(ToStringUtils.Boost(Boost));return buffer.ToString();}
public Int64sRef Next(int count){Debug.Assert(count > 0);if (ord == valueCount){throw new System.IO.EndOfStreamException();}if (off == blockSize){Refill();}count = Math.Min(count, blockSize - off);count = (int)Math.Min(count, valueCount - ord);valuesRef.Offset = off;valuesRef.Length = count;off += count;ord += count;return valuesRef;}
public virtual ListTrainingJobsResponse ListTrainingJobs(ListTrainingJobsRequest request){var options = new InvokeOptions();options.RequestMarshaller = ListTrainingJobsRequestMarshaller.Instance;options.ResponseUnmarshaller = ListTrainingJobsResponseUnmarshaller.Instance;return Invoke<ListTrainingJobsResponse>(request, options);}
public virtual DecreaseReplicationFactorResponse DecreaseReplicationFactor(DecreaseReplicationFactorRequest request){var options = new InvokeOptions();options.RequestMarshaller = DecreaseReplicationFactorRequestMarshaller.Instance;options.ResponseUnmarshaller = DecreaseReplicationFactorResponseUnmarshaller.Instance;return Invoke<DecreaseReplicationFactorResponse>(request, options);}
public override void Decode(byte[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations){for (int i = 0; i < iterations; ++i){int byte0 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = (int)((uint)byte0 >> 5);values[valuesOffset++] = ((int)((uint)byte0 >> 2)) & 7;int byte1 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = ((byte0 & 3) << 1) | ((int)((uint)byte1 >> 7));values[valuesOffset++] = ((int)((uint)byte1 >> 4)) & 7;values[valuesOffset++] = ((int)((uint)byte1 >> 1)) & 7;int byte2 = blocks[blocksOffset++] & 0xFF;values[valuesOffset++] = ((byte1 & 1) << 2) | ((int)((uint)byte2 >> 6));values[valuesOffset++] = ((int)((uint)byte2 >> 3)) & 7;values[valuesOffset++] = byte2 & 7;}}
public virtual DeleteLifecycleHookResponse DeleteLifecycleHook(DeleteLifecycleHookRequest request){var options = new InvokeOptions();options.RequestMarshaller = DeleteLifecycleHookRequestMarshaller.Instance;options.ResponseUnmarshaller = DeleteLifecycleHookResponseUnmarshaller.Instance;return Invoke<DeleteLifecycleHookResponse>(request, options);}
public override string GetSignerName(){return ALGORITHM_NAME;}
public virtual bool Get(string name, bool dflt){bool[] vals;object temp;if (valByRound.TryGetValue(name, out temp) && temp != null){vals = (bool[])temp;return vals[roundNumber % vals.Length];}string sval;if (!props.TryGetValue(name, out sval)){sval = dflt.ToString(); }if (sval.IndexOf(':') < 0){return bool.Parse(sval);}int k = sval.IndexOf(':');string colName = sval.Substring(0, k - 0);sval = sval.Substring(k + 1);colForValByRound[name] = colName;vals = PropToBooleanArray(sval);valByRound[name] = vals;return vals[roundNumber % vals.Length];}
public virtual DescribeCacheClustersResponse DescribeCacheClusters(DescribeCacheClustersRequest request){var options = new InvokeOptions();options.RequestMarshaller = DescribeCacheClustersRequestMarshaller.Instance;options.ResponseUnmarshaller = DescribeCacheClustersResponseUnmarshaller.Instance;return Invoke<DescribeCacheClustersResponse>(request, options);}
public override ValueEval Evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0){ValueEval veText;try{veText = OperandResolver.GetSingleValue(arg0, srcRowIndex, srcColumnIndex);}catch (EvaluationException e){return e.GetErrorEval();}String strText = OperandResolver.CoerceValueToString(veText);Double result = ConvertTextToNumber(strText);if (Double.IsNaN(result)){return ErrorEval.VALUE_INVALID;}return new NumberEval(result);}
public long RamBytesUsed(){long mem = RamUsageEstimator.ShallowSizeOf(this) + RamUsageEstimator.SizeOf(Offsets);if (Offsets != Ordinals){mem += RamUsageEstimator.SizeOf(Ordinals);}return mem;}
public virtual ImportDocumentationPartsResponse ImportDocumentationParts(ImportDocumentationPartsRequest request){var options = new InvokeOptions();options.RequestMarshaller = ImportDocumentationPartsRequestMarshaller.Instance;options.ResponseUnmarshaller = ImportDocumentationPartsResponseUnmarshaller.Instance;return Invoke<ImportDocumentationPartsResponse>(request, options);}
public bool IsEmpty(){return beginA == endA && beginB == endB;}
public override bool Equals(object obj){if (this == obj){return true;}if (obj == null){return false;}if (GetType() != obj.GetType()){return false;}WeightedPhraseInfo other = (WeightedPhraseInfo)obj;if (StartOffset != other.StartOffset){return false;}if (EndOffset != other.EndOffset){return false;}if (Boost != other.Boost){return false;}return true;}
public override int Preceding(int pos){if (pos < start || pos > end){throw new ArgumentException("offset out of bounds");}else if (pos == start){current = start;return Done;}else{return First();}}
public NumericPayloadTokenFilter(TokenStream input, float payload, string typeMatch): base(input){if (typeMatch == null){throw new ArgumentException("typeMatch cannot be null");}thePayload = new BytesRef(PayloadHelper.EncodeSingle(payload));this.typeMatch = typeMatch;this.payloadAtt = AddAttribute<IPayloadAttribute>();this.typeAtt = AddAttribute<ITypeAttribute>();}
public virtual void SetCRC(int crc){this.crc = crc;}
public override java.nio.DoubleBuffer duplicate(){java.nio.ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());java.nio.DoubleToByteBufferAdapter buf = new java.nio.DoubleToByteBufferAdapter(bb);buf._limit = _limit;buf._position = _position;buf._mark = _mark;return buf;}
public PhoneticFilterFactory(IDictionary<string, string> args): base(args){inject = GetBoolean(args, INJECT, true);name = Require(args, ENCODER);string v = Get(args, MAX_CODE_LENGTH);if (v != null){maxCodeLength = int.Parse(v, CultureInfo.InvariantCulture);}else{maxCodeLength = null;}if (!(args.Count == 0)){throw new ArgumentException("Unknown parameters: " + args);}}
public int AddString(UnicodeString str){field_1_num_strings++;UnicodeString ucs = (str == null) ? EMPTY_STRING: str;int rval;int index = field_3_strings.GetIndex(ucs);if (index != -1){rval = index;}else{rval = field_3_strings.Size;field_2_num_unique_strings++;SSTDeserializer.AddToStringTable(field_3_strings, ucs);}return rval;}
public CellRangeAddressList(){_list = new ArrayList();}
public virtual InitiateLayerUploadResponse InitiateLayerUpload(InitiateLayerUploadRequest request){var options = new InvokeOptions();options.RequestMarshaller = InitiateLayerUploadRequestMarshaller.Instance;options.ResponseUnmarshaller = InitiateLayerUploadResponseUnmarshaller.Instance;return Invoke<InitiateLayerUploadResponse>(request, options);}
public virtual DescribeOptionGroupsResponse DescribeOptionGroups(){return DescribeOptionGroups(new DescribeOptionGroupsRequest());}
public HSSFShapeGroup CreateGroup(HSSFChildAnchor anchor){HSSFShapeGroup group = new HSSFShapeGroup(this, anchor);group.Parent = this;group.Anchor = anchor;shapes.Add(group);OnCreate(group);return group;}
public static CharsRef Join(string[] words, CharsRef reuse){int upto = 0;char[] buffer = reuse.Chars;foreach (string word in words){int wordLen = word.Length;int needed = (0 == upto ? wordLen : 1 + upto + wordLen); if (needed > buffer.Length){reuse.Grow(needed);buffer = reuse.Chars;}if (upto > 0){buffer[upto++] = SynonymMap.WORD_SEPARATOR;}word.CopyTo(0, buffer, upto, wordLen - 0);upto += wordLen;}reuse.Length = upto;return reuse;}
public int GetBackgroundImageId(){EscherSimpleProperty property = (EscherSimpleProperty)GetOptRecord().Lookup(EscherProperties.FILL__PATTERNTEXTURE);return property == null ? 0 : property.PropertyValue;}
public virtual TreeFilter GetTreeFilter(){return treeFilter;}
public virtual void SetStreamFileThreshold(int newLimit){streamFileThreshold = newLimit;}
public override long Get(int index){int o = (int)((uint)index >> 6);int b = index & 63;int shift = b << 0;return ((long)((ulong)blocks[o] >> shift)) & 1L;}
public virtual void clear(){lock (this){if (_size != 0){java.util.Arrays.fill(table, null);modCount++;_size = 0;}}}
public ValueEval Evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0, ValueEval arg1,ValueEval arg2, ValueEval arg3, ValueEval arg4){double result;try{double d0 = NumericFunction.SingleOperandEvaluate(arg0, srcRowIndex, srcColumnIndex);double d1 = NumericFunction.SingleOperandEvaluate(arg1, srcRowIndex, srcColumnIndex);double d2 = NumericFunction.SingleOperandEvaluate(arg2, srcRowIndex, srcColumnIndex);double d3 = NumericFunction.SingleOperandEvaluate(arg3, srcRowIndex, srcColumnIndex);double d4 = NumericFunction.SingleOperandEvaluate(arg4, srcRowIndex, srcColumnIndex);result = Evaluate(d0, d1, d2, d3, d4 != 0.0);NumericFunction.CheckValue(result);}catch (EvaluationException e){return e.GetErrorEval();}return new NumberEval(result);}
public static void Mkdir(FilePath d, bool skipExisting){if (!d.Mkdir()){if (skipExisting && d.IsDirectory()){return;}throw new IOException(MessageFormat.Format(JGitText.Get().mkDirFailed, d.GetAbsolutePath()));}}
public virtual void SetPackedGitMMAP(bool usemmap){packedGitMMAP = usemmap;}
public virtual GetCelebrityInfoResponse GetCelebrityInfo(GetCelebrityInfoRequest request){var options = new InvokeOptions();options.RequestMarshaller = GetCelebrityInfoRequestMarshaller.Instance;options.ResponseUnmarshaller = GetCelebrityInfoResponseUnmarshaller.Instance;return Invoke<GetCelebrityInfoResponse>(request, options);}
public override java.util.Enumeration<V> elements(){lock (this){return new java.util.Hashtable<K, V>.ValueEnumeration(this);}}
public virtual DescribeAvailabilityOptionsResponse DescribeAvailabilityOptions(DescribeAvailabilityOptionsRequest request){var options = new InvokeOptions();options.RequestMarshaller = DescribeAvailabilityOptionsRequestMarshaller.Instance;options.ResponseUnmarshaller = DescribeAvailabilityOptionsResponseUnmarshaller.Instance;return Invoke<DescribeAvailabilityOptionsResponse>(request, options);}
public virtual UpdateReceiptRuleResponse UpdateReceiptRule(UpdateReceiptRuleRequest request){var options = new InvokeOptions();options.RequestMarshaller = UpdateReceiptRuleRequestMarshaller.Instance;options.ResponseUnmarshaller = UpdateReceiptRuleResponseUnmarshaller.Instance;return Invoke<UpdateReceiptRuleResponse>(request, options);}
public UnmappableCharacterException(int length){this.inputLength = length;}
public virtual void SetKeepEmpty(bool empty){keepEmpty = empty;}
public virtual GetBlockResponse GetBlock(GetBlockRequest request){var options = new InvokeOptions();options.RequestMarshaller = GetBlockRequestMarshaller.Instance;options.ResponseUnmarshaller = GetBlockResponseUnmarshaller.Instance;return Invoke<GetBlockResponse>(request, options);}
public ValueEval GetRef3DEval(Ref3DPxg rptg){SheetRangeEvaluator sre = CreateExternSheetRefEvaluator(rptg.SheetName, rptg.LastSheetName, rptg.ExternalWorkbookNumber);return new LazyRefEval(rptg.Row, rptg.Column, sre);}
public DVRecord(RecordInputStream in1){_option_flags = in1.ReadInt();_promptTitle = ReadUnicodeString(in1);_errorTitle = ReadUnicodeString(in1);_promptText = ReadUnicodeString(in1);_errorText = ReadUnicodeString(in1);int field_size_first_formula = in1.ReadUShort();_not_used_1 = in1.ReadShort();_formula1 = NPOI.SS.Formula.Formula.Read(field_size_first_formula, in1);int field_size_sec_formula = in1.ReadUShort();_not_used_2 = in1.ReadShort();_formula2 = NPOI.SS.Formula.Formula.Read(field_size_sec_formula, in1);_regions = new CellRangeAddressList(in1);}
public IntMapper(int InitialCapacity){elements = new List<T>(InitialCapacity);valueKeyMap = new Dictionary<T, int>(InitialCapacity);}
public DescribeTagsRequest(List<Filter> filters){_filters = filters;}
public sealed override java.nio.CharBuffer get(char[] dst, int dstOffset, int charCount){java.util.Arrays.checkOffsetAndCount(dst.Length, dstOffset, charCount);if (charCount > remaining()){throw new java.nio.BufferUnderflowException();}int newPosition = _position + charCount;Sharpen.StringHelper.GetCharsForString(sequence.ToString(), _position, newPosition, dst, dstOffset);_position = newPosition;return this;}
public NewAnalyzerTask(PerfRunData runData): base(runData){analyzerNames = new List<string>();}
public virtual void copyInto(object[] elements_1){lock (this){System.Array.Copy(elementData, 0, elements_1, 0, elementCount);}}
public virtual DescribeDBClustersResponse DescribeDBClusters(DescribeDBClustersRequest request){var options = new InvokeOptions();options.RequestMarshaller = DescribeDBClustersRequestMarshaller.Instance;options.ResponseUnmarshaller = DescribeDBClustersResponseUnmarshaller.Instance;return Invoke<DescribeDBClustersResponse>(request, options);}
public virtual SearchAddressBooksResponse SearchAddressBooks(SearchAddressBooksRequest request){var options = new InvokeOptions();options.RequestMarshaller = SearchAddressBooksRequestMarshaller.Instance;options.ResponseUnmarshaller = SearchAddressBooksResponseUnmarshaller.Instance;return Invoke<SearchAddressBooksResponse>(request, options);}
public virtual TestFailoverResponse TestFailover(TestFailoverRequest request){var options = new InvokeOptions();options.RequestMarshaller = TestFailoverRequestMarshaller.Instance;options.ResponseUnmarshaller = TestFailoverResponseUnmarshaller.Instance;return Invoke<TestFailoverResponse>(request, options);}
public override string ToString(string field){StringBuilder buffer = new StringBuilder();buffer.Append("spanFirst(");buffer.Append(m_match.ToString(field));buffer.Append(", ");buffer.Append(m_end);buffer.Append(")");buffer.Append(ToStringUtils.Boost(Boost));return buffer.ToString();}
public override int lastIndexOf(object @object){if (@object != null){{for (int i = a.Length - 1; i >= 0; i--){if (@object.Equals(a[i])){return i;}}}}else{{for (int i = a.Length - 1; i >= 0; i--){if ((object)a[i] == null){return i;}}}}return -1;}
public virtual CreateEnvironmentResponse CreateEnvironment(CreateEnvironmentRequest request){var options = new InvokeOptions();options.RequestMarshaller = CreateEnvironmentRequestMarshaller.Instance;options.ResponseUnmarshaller = CreateEnvironmentResponseUnmarshaller.Instance;return Invoke<CreateEnvironmentResponse>(request, options);}
public virtual DisableInsightRulesResponse DisableInsightRules(DisableInsightRulesRequest request){var options = new InvokeOptions();options.RequestMarshaller = DisableInsightRulesRequestMarshaller.Instance;options.ResponseUnmarshaller = DisableInsightRulesResponseUnmarshaller.Instance;return Invoke<DisableInsightRulesResponse>(request, options);}
public override String ToString(){StringBuilder sb = new StringBuilder();String recordName = this.RecordName;sb.Append("[").Append(recordName).Append("]\n");sb.Append("    .row    = ").Append(HexDump.ShortToHex(Row)).Append("\n");sb.Append("    .col    = ").Append(HexDump.ShortToHex(Column)).Append("\n");if (IsBiff2){sb.Append("    .cellattrs = ").Append(HexDump.ShortToHex(CellAttrs)).Append("\n");}else{sb.Append("    .xFindex   = ").Append(HexDump.ShortToHex(XFIndex)).Append("\n");}AppendValueText(sb);sb.Append("\n");sb.Append("[/").Append(recordName).Append("]\n");return sb.ToString();}
public virtual DeleteEvaluationResponse DeleteEvaluation(DeleteEvaluationRequest request){var options = new InvokeOptions();options.RequestMarshaller = DeleteEvaluationRequestMarshaller.Instance;options.ResponseUnmarshaller = DeleteEvaluationResponseUnmarshaller.Instance;return Invoke<DeleteEvaluationResponse>(request, options);}
public void RegisterListener(POIFSReaderListener listener){if (listener == null){throw new NullReferenceException();}if (registryClosed){throw new InvalidOperationException();}registry.RegisterListener(listener);}
public virtual UpdateFieldLevelEncryptionProfileResponse UpdateFieldLevelEncryptionProfile(UpdateFieldLevelEncryptionProfileRequest request){var options = new InvokeOptions();options.RequestMarshaller = UpdateFieldLevelEncryptionProfileRequestMarshaller.Instance;options.ResponseUnmarshaller = UpdateFieldLevelEncryptionProfileResponseUnmarshaller.Instance;return Invoke<UpdateFieldLevelEncryptionProfileResponse>(request, options);}
public virtual GetDocumentVersionResponse GetDocumentVersion(GetDocumentVersionRequest request){var options = new InvokeOptions();options.RequestMarshaller = GetDocumentVersionRequestMarshaller.Instance;options.ResponseUnmarshaller = GetDocumentVersionResponseUnmarshaller.Instance;return Invoke<GetDocumentVersionResponse>(request, options);}
public static void fill(object[] array, object value){{for (int i = 0; i < array.Length; i++){array[i] = value;}}}
public override void Decode(long[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations){for (int i = 0; i < iterations; ++i){long block = blocks[blocksOffset++];valuesOffset = Decode(block, values, valuesOffset);}}
public ValueEval Evaluate(ValueEval[] args, OperationEvaluationContext ec){throw new NotImplementedFunctionException(_functionName);}
public SrndPrefixQuery(string prefix, bool quoted, char truncator): base(quoted){this.prefix = prefix;prefixRef = new BytesRef(prefix);this.truncator = truncator;}
public virtual ICollection<string> GetAdded(){return Sharpen.Collections.UnmodifiableSet(diff.GetAdded());}
public virtual Hyphenation Hyphenate(string word, int remainCharCount, int pushCharCount){char[] w = word.ToCharArray();return Hyphenate(w, 0, w.Length, remainCharCount, pushCharCount);}
public static Type LookupClass(string name){return loader.LookupClass(name);}
public override java.nio.ByteBuffer put(byte b){throw new java.nio.ReadOnlyBufferException();}
public java.util.MapClass.Entry<K, V> lastEntry(){return this._enclosing.immutableCopy(this.endpoint(false));}
public override string ToString(){return Key + "/" + Value;}
public virtual Ent Peek(){if (this.packedIdx < this._enclosing.packed.Size() && this.looseIdx < this._enclosing.loose.Size()){Ref p = this._enclosing.packed.Get(this.packedIdx);Ref l = this._enclosing.loose.Get(this.looseIdx);int cmp = RefComparator.CompareTo(p, l);if (cmp < 0){this.packedIdx++;return this.ToEntry(p);}if (cmp == 0){this.packedIdx++;}this.looseIdx++;return this.ToEntry(this.ResolveLoose(l));}if (this.looseIdx < this._enclosing.loose.Size()){return this.ToEntry(this.ResolveLoose(this._enclosing.loose.Get(this.looseIdx++)));}if (this.packedIdx < this._enclosing.packed.Size()){return this.ToEntry(this._enclosing.packed.Get(this.packedIdx++));}return null;}
public ModifyCacheClusterRequest(string cacheClusterId){_cacheClusterId = cacheClusterId;}
public virtual NGit.Api.DiffCommand SetDestinationPrefix(string destinationPrefix){this.destinationPrefix = destinationPrefix;return this;}
public static string canonicalizePath(string path, bool discardRelativePrefix){int segmentStart = 0;int deletableSegments = 0;{for (int i = 0; i <= path.Length; ){int nextSegmentStart;if (i == path.Length){nextSegmentStart = i;}else{if (path[i] == '/'){nextSegmentStart = i + 1;}else{i++;continue;}}if (i == segmentStart + 1 && Sharpen.StringHelper.RegionMatches(path, segmentStart, ".", 0, 1)){path = Sharpen.StringHelper.Substring(path, 0, segmentStart) + Sharpen.StringHelper.Substring(path, nextSegmentStart);i = segmentStart;}else{if (i == segmentStart + 2 && Sharpen.StringHelper.RegionMatches(path, segmentStart, "..", 0, 2)){if (deletableSegments > 0 || discardRelativePrefix){deletableSegments--;int prevSegmentStart = path.LastIndexOf('/', segmentStart - 2) + 1;path = Sharpen.StringHelper.Substring(path, 0, prevSegmentStart) + Sharpen.StringHelper.Substring(path, nextSegmentStart);i = segmentStart = prevSegmentStart;}else{i++;segmentStart = i;}}else{if (i > 0){deletableSegments++;}i++;segmentStart = i;}}}}return path;}
public override String ToString(){StringBuilder buffer = new StringBuilder();buffer.Append("[REFRESHALL]\n");buffer.Append("    .refreshall      = ").Append(RefreshAll).Append("\n");buffer.Append("[/REFRESHALL]\n");return buffer.ToString();}
public CustomViewSettingsRecordAggregate(RecordStream rs){_begin = rs.GetNext();if (_begin.Sid != UserSViewBegin.sid){throw new InvalidOperationException("Bad begin record");}List<RecordBase> temp = new List<RecordBase>();while (rs.PeekNextSid() != UserSViewEnd.sid){if (PageSettingsBlock.IsComponentRecord(rs.PeekNextSid())){if (_psBlock != null){throw new InvalidOperationException("Found more than one PageSettingsBlock in custom view Settings sub-stream");}_psBlock = new PageSettingsBlock(rs);temp.Add(_psBlock);continue;}temp.Add(rs.GetNext());}_recs = temp;_end = rs.GetNext(); if (_end.Sid != UserSViewEnd.sid){throw new InvalidOperationException("Bad custom view Settings end record");}}
public virtual CreatePipelineResponse CreatePipeline(CreatePipelineRequest request){var options = new InvokeOptions();options.RequestMarshaller = CreatePipelineRequestMarshaller.Instance;options.ResponseUnmarshaller = CreatePipelineResponseUnmarshaller.Instance;return Invoke<CreatePipelineResponse>(request, options);}
public virtual void EndWorker(){if (workers.DecrementAndGet() == 0){process.Release();}}
public virtual UpdateDetectorVersionMetadataResponse UpdateDetectorVersionMetadata(UpdateDetectorVersionMetadataRequest request){var options = new InvokeOptions();options.RequestMarshaller = UpdateDetectorVersionMetadataRequestMarshaller.Instance;options.ResponseUnmarshaller = UpdateDetectorVersionMetadataResponseUnmarshaller.Instance;return Invoke<UpdateDetectorVersionMetadataResponse>(request, options);}
public ValueEval Evaluate(ValueEval[] args, OperationEvaluationContext ec){double result;if (args.Length != 2){return ErrorEval.VALUE_INVALID;}try{double startDateAsNumber = GetValue(args[0]);int offsetInMonthAsNumber = (int)GetValue(args[1]);DateTime startDate = DateUtil.GetJavaDate(startDateAsNumber);DateTime resultDate = startDate.AddMonths(offsetInMonthAsNumber);result = DateUtil.GetExcelDate(resultDate);NumericFunction.CheckValue(result);return new NumberEval(result);}catch (EvaluationException e){return e.GetErrorEval();}}
public virtual string getEncoding(){if (encoder == null){return null;}return java.io.HistoricalCharsetNames.get(encoder.charset());}
public virtual UpdateBasePathMappingResponse UpdateBasePathMapping(UpdateBasePathMappingRequest request){var options = new InvokeOptions();options.RequestMarshaller = UpdateBasePathMappingRequestMarshaller.Instance;options.ResponseUnmarshaller = UpdateBasePathMappingResponseUnmarshaller.Instance;return Invoke<UpdateBasePathMappingResponse>(request, options);}
public UpdateRepoRequest(): base("cr", "2016-06-07", "UpdateRepo", "cr", "openAPI"){UriPattern = "/repos/[RepoNamespace]/[RepoName]";Method = MethodType.POST;}
public virtual DescribeMetricCollectionTypesResponse DescribeMetricCollectionTypes(DescribeMetricCollectionTypesRequest request){var options = new InvokeOptions();options.RequestMarshaller = DescribeMetricCollectionTypesRequestMarshaller.Instance;options.ResponseUnmarshaller = DescribeMetricCollectionTypesResponseUnmarshaller.Instance;return Invoke<DescribeMetricCollectionTypesResponse>(request, options);}
public virtual UpdateDocumentResponse UpdateDocument(UpdateDocumentRequest request){var options = new InvokeOptions();options.RequestMarshaller = UpdateDocumentRequestMarshaller.Instance;options.ResponseUnmarshaller = UpdateDocumentResponseUnmarshaller.Instance;return Invoke<UpdateDocumentResponse>(request, options);}
public static void fill(int[] array, int value){{for (int i = 0; i < array.Length; i++){array[i] = value;}}}
public virtual bool Has(AnyObjectId objectId, int typeHint){try{Open(objectId, typeHint);return true;}catch (MissingObjectException){return false;}}
public override object ToObject(){return Exists ? (object)Value : null;}
public QueryScorer(Query query, string field){Init(query, field, null, true);}
public override ValueEval Evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0){int result;if (arg0 is TwoDEval){result = ((TwoDEval)arg0).Height;}else if (arg0 is RefEval){result = 1;}else{ return ErrorEval.VALUE_INVALID;}return new NumberEval(result);}
public override java.util.Iterator<java.util.MapClass.Entry<K, V>> iterator(){return new java.util.Hashtable<K, V>.EntryIterator(this._enclosing);}
public override String ToString(){StringBuilder sb = new StringBuilder();sb.Append("[").Append("USERSVIEWEND").Append("] (0x");sb.Append(StringUtil.ToHexString(sid).ToUpper() + ")\n");sb.Append("  rawData=").Append(HexDump.ToHex(_rawData)).Append("\n");sb.Append("[/").Append("USERSVIEWEND").Append("]\n");return sb.ToString();}
public StringPtg(ILittleEndianInput in1){int field_1_length = in1.ReadUByte();field_2_options = (byte)in1.ReadByte();_is16bitUnicode = (field_2_options & 0x01) != 0;if (_is16bitUnicode){field_3_string = StringUtil.ReadUnicodeLE(in1, field_1_length);}else{field_3_string = StringUtil.ReadCompressedUnicode(in1, field_1_length);}}
public virtual X509Certificate[] GetAcceptedIssuers(){return null;}
public virtual GetIntegrationResponsesResponse GetIntegrationResponses(GetIntegrationResponsesRequest request){var options = new InvokeOptions();options.RequestMarshaller = GetIntegrationResponsesRequestMarshaller.Instance;options.ResponseUnmarshaller = GetIntegrationResponsesResponseUnmarshaller.Instance;return Invoke<GetIntegrationResponsesResponse>(request, options);}
public virtual CreateBrokerResponse CreateBroker(CreateBrokerRequest request){var options = new InvokeOptions();options.RequestMarshaller = CreateBrokerRequestMarshaller.Instance;options.ResponseUnmarshaller = CreateBrokerResponseUnmarshaller.Instance;return Invoke<CreateBrokerResponse>(request, options);}